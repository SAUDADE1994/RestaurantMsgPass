package clientSide.entities;

import clientSide.main.SimulPar;
import clientSide.stubs.BarStub;
import clientSide.stubs.TableStub;



/**
 *   Student thread.
 *
 *   Used to simulate the Student life cycle.
 *   Static solution.
 */
public class Student extends Thread {

    /**
     * Student ID - Defined by the order of arrival, starting with 0
     */
    private int studentId;

    /**
     * Student State
     */
    private int studentState;


    /**
     * Flag to Sleep while waiting for the waiter to salute and then reads the menu
     */
    private boolean selected;

    /**
     * Flag set True when is the first student to arrive
     */
    private boolean firstStudentToArrive;

    /**
     * Flag set True when is the last student to arrive
     */
    private boolean lastStudentToArrive;

    /**
     * Signals if current student is waiting for next portion
     */
    private boolean isWaitingForPortion;

    /**
     * Reference to the Table
     */
    private final TableStub table;

    /**
     * Reference to the Bar
     */
    private final BarStub bar;


    /**
     * Instantiation of Student Thread
     *
     * @param studentId student id
     * @param table reference to the table
     * @param bar reference to the bar
     */
    public Student(int studentId, TableStub table, BarStub bar) {
        super(String.format("Student %d", studentId));
        this.studentId = studentId;
        this.bar = bar;
        this.studentState = StudentStates.GOING_TO_THE_RESTAURANT;
        this.table = table;
        selected = false;
        firstStudentToArrive = false;
        lastStudentToArrive = false;
    }

    /**
     * Student lifecycle
     *
     * Starts at the state GOING_TO_THE_RESTAURANT
     * Ends at the state GOING_HOME after eating at the restaurant
     */
    @Override
    public void run() {

        // arrives at the restaurant and after saluted by waiter reads the menu
        walkABit();
        table.enter();
        table.readTheMenu();

        // if it's the first student to arrive
        if(firstStudentToArrive) {
            table.prepareTheOrder();                    // prepares all the orders and signals waiter
            while (!table.hasEverybodyChosen()) {
                // Get the id
                Integer[] readyStudents = table.askForReadyOrders();
                if (readyStudents[0] != 0) {
                    for (int i = 1; i < readyStudents.length; i++) {
                        table.addUpOnesChoices(readyStudents[i]);
                    }
                }
            }
            table.callTheWaiter();
            table.describeTheOrder();
            table.joinTheTalk();
        } else
            table.informCompanion();                // if it is not, informs the first student
                                                    // to arrive of which order he wants


        // starts eating de 0 upto M courses
        for (int i = 0; i < SimulPar.TOTAL_COURSES; i++) {

            table.startEating(i+1);
            boolean lastOneToFinishEating = table.endEating();

            if (lastOneToFinishEating) {        // if its the last one eating signals waiter
                table.signalTheWaiter();        // to prepare/serve the next course
            }

        }

        // if is the last student to arrive he pays the bill
        if (lastStudentToArrive) {
            table.shouldHaveArrivedEarlier();
            table.honorTheBill();
        }

        // The student goes home
        table.exit();
    }

    /**
     * Student walks a bit before entering the restaurant
     * Sleeps for a random time between 0 and 100 ms
     */
    private void walkABit() {
        try
        {
            sleep ((long) (1 + 100 * Math.random ()));
        }
        catch (InterruptedException ignored) {}
    }

    /**
     * Gets student id
     *
     * @return student id
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Sets the student state
     *
     * @param studentState student state
     */
    public void setStudentState(int studentState) {
        //repos.setStudentState(studentId, studentState);
        this.studentState = studentState;
    }

    /**
     * Gets the selected flag
     *
     * @return selected flag
     */
    public boolean getSelected() {
        return selected;
    }

    /**
     * Sets the selected flag
     *
     * @param selected selected flag
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * Sets the first student to arrive
     *
     * @param firstStudentToArrive first student to arrive flag
     */
    public void setFirstStudentToArrive(boolean firstStudentToArrive) {
        this.firstStudentToArrive = firstStudentToArrive;
    }

    /**
     * Verify if it's the last student to arrive
     *
     * @return last student to arrive flag
     */
    public boolean isLastStudentToArrive() {
        return lastStudentToArrive;
    }

    /**
     * Sets last student to arrive flag
     *
     * @param lastStudentToArrive last student to arrive flag
     */
    public void setLastStudentToArrive(boolean lastStudentToArrive) {
        this.lastStudentToArrive = lastStudentToArrive;
    }

    public int getStudentState() {
        return this.studentState;
    }
}
