package serverSide.sharedRegions;

import commInfra.MemException;
import commInfra.MemFIFO;
import serverSide.entities.Student;
import serverSide.entities.StudentStates;
import serverSide.entities.Waiter;
import serverSide.entities.WaiterStates;
import serverSide.main.SimulPar;
import serverSide.stubs.GeneralReposStub;

import static java.lang.Thread.sleep;

/**
 * Table
 *
 * It is responsible to keep track of the students, when arriving, eating and billing.
 * Is implemented using as an implicit monitor
 */
public class Table implements ITable_Student, ITable_Waiter {

    /**
     * Holds information about the students at the current table
     */
    private final Student[] students;

    /**
     * Number of students that have arrived at the restaurant
     */
    private int numberOfStudentsArrived;

    /**
     * Flag is set true when a student arrives to the restaurant
     * and is set false when waiter salutes the student
     */
    private boolean salute;

    /**
     * Flag is true only after the waiter has presented the bill
     * to the last student
     */
    private boolean billPresented;

    /**
     * Flag is true only after the last student has paid the dinner
     */
    private boolean isDinnerPaid;

    /**
     * FIFO Queue for students that have arrived at the Restaurant and are waiting to check in.
     */
    private MemFIFO<Integer> checkInQueue;

    /**
     * FIFO Queue for placed orders of the students
     */
    private MemFIFO<Integer> orders;

    /**
     * FIFO Queue for placed orders of the students
     */
    private MemFIFO<Integer> pendingOrdersQueue;

    /**
     * Flag for each student: is true only when the respective student
     * has decided what to order but the first student to arrive has not accounted for it yet
     */
    private final boolean[] peerWantsToOrder;

    /**
     * Flag is true only after the first student to arrive has
     * accounted for orders from all his colleagues
     */
    private boolean orderIsChosen;

    /**
     * Flag is true only after the students have all finished eating all courses,
     * and thus are ready for payment
     */
    public boolean readyForPayment;

    /**
     * During the courses, this flag indicated, for each student,
     * whether the waiter has served his portion to him
     */
    private boolean[] currentCoursePortionsServed;

    /**
     * During the courses, this counter indicates, for each student,
     * how many portions he has eaten
     */
    private MemFIFO<Integer> portionsEaten;

    /**
     * Flag is set true after the waiter has registered the student's orders
     */
    private boolean orderIsWritten;

    /**
     * Flag is set true after the first student to arrive finishes
     * describing the full order to the waiter
     */
    private boolean orderIsDescribed;

    /**
     * Flag set to true only when the last student to finish a course calls him,
     * and is set to false right after the waiter was alerted
     */
    private boolean waiterWrapUpCourse;

    /**
     * Flag is true when the students are ready
     * to be served the next course's portions
     */
    private boolean areStudentsReadyForNextCourse;

    /**
     * Reference to the General Repository
     */
    private final GeneralReposStub repos;



    /**
     * Table initialization: Singleton -> private
     */
    public Table(GeneralReposStub repos) {
        this.repos = repos;
        students = new Student[SimulPar.TOTAL_STUDENTS];

        try {
            orders = new MemFIFO<>(new Integer[SimulPar.TOTAL_STUDENTS]);
            checkInQueue = new MemFIFO<>(new Integer[SimulPar.TOTAL_STUDENTS]);
            pendingOrdersQueue = new MemFIFO<>(new Integer[SimulPar.TOTAL_STUDENTS]);
            portionsEaten = new MemFIFO<>(new Integer[SimulPar.TOTAL_STUDENTS * SimulPar.TOTAL_COURSES]);
        } catch (MemException e) {
            checkInQueue = null;
            orders = null;
            System.exit(1);
        }

        // Some flags to control de execution of the threads
        salute = false;
        billPresented = false;
        isDinnerPaid = false;
        readyForPayment = false;
        orderIsChosen = false;
        orderIsWritten = false;
        orderIsDescribed = false;
        waiterWrapUpCourse = false;
        areStudentsReadyForNextCourse = false;

        numberOfStudentsArrived = 0;


        // Initialized false by default
        peerWantsToOrder = new boolean[SimulPar.TOTAL_STUDENTS];
        currentCoursePortionsServed = new boolean[SimulPar.TOTAL_STUDENTS];
    }

    @Override
    public synchronized int enter() {
        int studentId = ((Student) Thread.currentThread()).getStudentId();
        students[studentId] = (Student) Thread.currentThread();
        repos.setStudentIds(studentId);
        students[studentId].setStudentState(StudentStates.TAKING_A_SEAT_AT_THE_TABLE);
        repos.setStudentState(studentId, StudentStates.TAKING_A_SEAT_AT_THE_TABLE);

        System.out.printf("Student[%d]: Taking a seat at the table\n", studentId);

        try {
            checkInQueue.write(studentId);
        } catch (MemException e) {
            e.printStackTrace();
        }

        numberOfStudentsArrived++;
        salute = true;
        notifyAll();

        // For logging purposes
        ((Student) Thread.currentThread()).setArrivalOrder(numberOfStudentsArrived);

        return numberOfStudentsArrived;
    }

    @Override
    public synchronized void readTheMenu() {
        int studentId = ((Student) Thread.currentThread()).getStudentId();
        students[studentId] = (Student) Thread.currentThread();

        /* Sleep while waiting for the waiter to salute and then reads the menu */
        while (!checkInQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Student[%d]: Selecting the Course\n", studentId);
        students[studentId].setStudentState(StudentStates.SELECTING_THE_COURSES);
        repos.setStudentState(studentId, StudentStates.SELECTING_THE_COURSES);
    }

    @Override
    public synchronized void prepareTheOrder() {
        // Set state to organizing the order
        int studentID = ((Student) Thread.currentThread()).getStudentId();
        students[studentID].setStudentState(StudentStates.ORGANIZING_THE_ORDER);
        repos.setStudentState(studentID, StudentStates.ORGANIZING_THE_ORDER);

        System.out.printf("Student[%d] will be preparing the order\n", studentID);

        // Set the order for himself (student 1)
        try {
            pendingOrdersQueue.write(studentID);
            System.out.printf("Student[%d] (organizer) has chosen his own order\n", studentID);
        } catch (MemException memException) {
            System.out.printf("Student[%d] (organizer) has chosen his own order" +
                    ", but someone tried to ask twice (fifo full)\n", studentID);
            memException.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public synchronized void hasEverybodyChosen() {

        // When flag is true, it will never be reset
        while (!pendingOrdersQueue.full()) {  // wait while fifo is not full
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }

    }

    /**
     * @return the number of students who have not yet
     * had their order choices accounted for
     */
    private int ordersNotYetChosen() {
        return SimulPar.TOTAL_STUDENTS - orders.getN();
    }


    @Override
    public synchronized void addUpOnesChoice() {

        while (!pendingOrdersQueue.isEmpty()) {
            try {
                int attendedStudent = pendingOrdersQueue.read();
                System.out.printf("Student[%d]'s order has been accounted for\n", attendedStudent);
            } catch (MemException memException) {
                System.out.println("Organizer is attending to orders, however none exist (FIFO empty)");
                memException.printStackTrace();
                System.exit(1);
            }
        }

    }

    @Override
    public synchronized void informCompanion() {
        int studentID = ((Student) Thread.currentThread()).getStudentId();

        students[studentID].setStudentState(StudentStates.CHATTING_WITH_COMPANIONS);
        repos.setStudentState(studentID, StudentStates.CHATTING_WITH_COMPANIONS);

        // Flag true until first student adds up this one's choice
        peerWantsToOrder[studentID] = true;

        System.out.printf("Student[%d] has chosen his order\n", studentID);

        // Notify the organizer student
        try {
            pendingOrdersQueue.write(studentID);
        } catch (MemException memException) {
            pendingOrdersQueue = null;
            System.out.printf("Student[%d] -> someone tried to ask twice" +
                    " for his/her order (FIFO full)\n", studentID);
            memException.printStackTrace();
            System.exit(1);
        }

        notifyAll();

        // Wait while other students are calling the organizer
        while (!pendingOrdersQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }

    }

    @Override
    public synchronized void callTheWaiter() {
        System.out.printf("Student[%d] is calling the waiter\n", ((Student) Thread.currentThread()).getStudentId());
        notifyAll();
    }

    @Override
    public synchronized void describeTheOrder() {
        System.out.printf("Student[%d] is describing the order to the waiter\n",
                ((Student) Thread.currentThread()).getStudentId());

        // Sleep for a bit while describing the order to the waiter
        try {
            sleep(50L);
        } catch (InterruptedException ignored) {
        }

        orderIsDescribed = true;
        notifyAll();

        // Block while waiter has not yet written the order down
        while (!orderIsWritten) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }

        notifyAll();

        areStudentsReadyForNextCourse = true;

    }

    @Override
    public synchronized void joinTheTalk() {
        Student currentStudent = ((Student) Thread.currentThread());
        // Set state to chatting with companions
        currentStudent.setStudentState(StudentStates.CHATTING_WITH_COMPANIONS);
        repos.setStudentState(currentStudent.getStudentId(), StudentStates.CHATTING_WITH_COMPANIONS);

        System.out.printf("Student[%d] has joined the talk\n", currentStudent.getStudentId());

    }

    @Override
    public synchronized boolean hasEverybodyFinished(int courseNo) {
//        System.out.printf("DEBUG - Course %d -> Portions eaten %d\n", courseNo, portionsEaten.getN());
        return portionsEaten.getN() == courseNo * SimulPar.TOTAL_STUDENTS;
    }

    @Override
    public synchronized void startEating(int courseNo) {

        Student currentStudent = ((Student) Thread.currentThread());

        // Wait for all portions to be served
        // Only then, proceed to eating
        while (!currentCourseIsServed()) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }

        // Reset the flag
        areStudentsReadyForNextCourse = false;

        String suffix = getSuffix(courseNo);

        // Set state to enjoying meal
        currentStudent.setStudentState(StudentStates.ENJOYING_THE_MEAL);
        repos.setStudentState(currentStudent.getStudentId(), StudentStates.ENJOYING_THE_MEAL);


        System.out.printf("Student[%d] has started eating the %d%s course\n",
                currentStudent.getStudentId(), courseNo, suffix);
    }

    /**
     * @param number Interpreted as ordinal
     * @return Suffix of the number - e.g.: 1 maps to 'st' (1st), 2 to 'nd', etc.
     */
    private String getSuffix(int number) {
        String suffix = "th";
        if (number == 1) {
            suffix = "st";
        } else if (number == 2) {
            suffix = "nd";
        } else if (number == 3) {
            suffix = "rd";
        }
        return suffix;
    }

    @Override
    public synchronized void shouldHaveArrivedEarlier() {

        Student lastStudent = ((Student) Thread.currentThread());

        System.out.printf("Student[%d] now paying the full dinner (last one to arrive)\n", lastStudent.getStudentId());

        // Set state to paying the bill
        lastStudent.setStudentState(StudentStates.PAYING_THE_BILL);
        repos.setStudentState(lastStudent.getStudentId(), StudentStates.PAYING_THE_BILL);

        // Set flag to signal the waiter
        readyForPayment = true;

        notifyAll();

        // Block and wait for the operation presentTheBill of the waiter
        while (!billPresented) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public synchronized void honorTheBill() {
        // Set some flag in order let the other students know the payment is made
        isDinnerPaid = true;

        System.out.printf("Student[%d] has payed the bill\n", ((Student) Thread.currentThread()).getStudentId());

        notifyAll();
    }

    @Override
    public synchronized void exit() {

        Student student = ((Student) Thread.currentThread());

        // Wait for last student to pay
        if (!student.isLastStudentToArrive())
            System.out.printf("Student[%d] is waiting for the last student to arrive to pay the bill\n", student.getStudentId());

        while (!isDinnerPaid) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }

        Student currentStudent = ((Student) Thread.currentThread());

        // Set state to going home
        currentStudent.setStudentState(StudentStates.GOING_HOME);
        repos.setStudentState(currentStudent.getStudentId(), StudentStates.GOING_HOME);

        System.out.printf("Student[%d] is going home with his colleagues to finish the due work assignment\n",
                currentStudent.getStudentId());
    }

    @Override
    public synchronized boolean endEating(int courseNo) {
        // Wait up to about 100ms (eating process)
        try {
            sleep((long) (1 + 100 * Math.random()));
        } catch (InterruptedException ignored) {
        }

        Student student = ((Student) Thread.currentThread());

        // Set state to chatting with companions
        student.setStudentState(StudentStates.CHATTING_WITH_COMPANIONS);
        repos.setStudentState(student.getStudentId(), StudentStates.CHATTING_WITH_COMPANIONS);

        // Mark his portion as eaten
        try {
            portionsEaten.write(student.getStudentId());
        } catch (MemException e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.printf("Student[%d] has finished the current course\n", student.getStudentId());

        boolean lastStudentToFinishEating = true;

        // Last student to finish eating will never enter the while loop
        // The rest will wait for him to signal the waiter
        while (!hasEverybodyFinished(courseNo) && !areStudentsReadyForNextCourse) {
            lastStudentToFinishEating = false;
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }

//        System.out.printf("DEBUG - Student[%d] is last to finish? %b\n",
//                student.getStudentId(), lastStudentToFinishEating);

        notifyAll();

        return lastStudentToFinishEating;

    }

    @Override
    public synchronized void signalTheWaiter() {

        // Wait for waiter to collect the plates

        System.out.printf("Student[%d] was the last one to finish the current course. All ready for the next one\n",
                ((Student) Thread.currentThread()).getStudentId());

        // Flag for waiter to [get plates] and serve students
        waiterWrapUpCourse = true;
        // Flag for the students waiting for the signal
        areStudentsReadyForNextCourse = true;

        // Next course: portions are by default not served
        currentCoursePortionsServed = new boolean[SimulPar.TOTAL_STUDENTS];

        notifyAll();

    }

    @Override
    public synchronized int saluteTheClient() {

        while (!salute) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /* Waiter can present multiple menus at the same time */
        while (checkInQueue.getN() != 0) {
            int studentId = 0;
            try {
                studentId = checkInQueue.read();
            } catch (MemException e) {
                e.printStackTrace();
            }

            System.out.printf("Waiter: presenting the menu to student[%d]\n", studentId);
            ((Waiter) Thread.currentThread()).setWaiterState(WaiterStates.PRESENTING_THE_MENU);
            repos.setWaiterState(WaiterStates.PRESENTING_THE_MENU);
            notifyAll();
        }

        ((Waiter) Thread.currentThread()).setWaiterState(WaiterStates.APPRAISING_SITUATION);
        repos.setWaiterState(WaiterStates.APPRAISING_SITUATION);

        return numberOfStudentsArrived;
    }

    @Override
    public synchronized void getThePad() {

        ((Waiter) Thread.currentThread()).setWaiterState(WaiterStates.TAKING_THE_ORDER);
        repos.setWaiterState(WaiterStates.TAKING_THE_ORDER);

        System.out.println("Waiter is taking the student's orders...");

        while (!orderIsDescribed) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }

        System.out.println("Waiter has registered the order");
        orderIsWritten = true;
        notifyAll();

    }

    @Override
    public synchronized void presentTheBill() {

        // Set state to receiving payment
        ((Waiter) Thread.currentThread()).setWaiterState(WaiterStates.RECEIVING_PAYMENT);
        repos.setWaiterState(WaiterStates.RECEIVING_PAYMENT);

        // Set bill_presented flag
        billPresented = true;

        System.out.println("Waiter has presented the bill and is ready to receive payment");

        notifyAll();

        while (!isDinnerPaid) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
    }

    @Override
    public synchronized void lookAround() {

        // Case 1: Look around for incoming students that have not yet saluted
        // Case 2: Look for the first student to describe the order
        // Case 3: Look around for when the students have finished the current course during the eating phase
        // Case 4: Look for when the last student is ready to pay

        while (!readyForPayment && !waiterWrapUpCourse
                && checkInQueue.isEmpty() && (ordersNotYetChosen() != 0 || orderIsWritten)
                && !orderIsDescribed) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }

        // Reset flag
        waiterWrapUpCourse = false;

    }

    @Override
    public synchronized void deliverPortion(int portionsServed) {

        repos.setnPortion(portionsServed);

        // Wait for all students being ready for next course
        while (!areStudentsReadyForNextCourse) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }

        // Deliver to the first un-served student
        for (int i = 0; i < currentCoursePortionsServed.length; i++) {
            if (!currentCoursePortionsServed[i]) {
                System.out.printf("Waiter has served a portion to student [%d]\n", i);
                // Student[i] has been served
                currentCoursePortionsServed[i] = true;
                // Notify student to start eating
                notifyAll();
                return;
            }
        }

        repos.setWaiterState(WaiterStates.APPRAISING_SITUATION);

        if (portionsServed == SimulPar.TOTAL_STUDENTS)
            repos.setNextCourse();

        // If all students have been served
        throw new IllegalStateException("Waiter is trying to deliver a portion but everyone seems to have been served");
    }

    /**
     * Verifies if every course is served (internal function of the shared region Table)
     *
     * @return True if everyone is served for the course at hand
     */
    public boolean currentCourseIsServed() {
        for (boolean studentCourseIsServed : currentCoursePortionsServed) {
            if (!studentCourseIsServed)
                return false;
        }
        return true;
    }

}