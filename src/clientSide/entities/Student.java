package clientSide.entities;

import clientSide.main.SimulPar;
import clientSide.stubs.TableStub;
import genclass.GenericIO;


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
    private int arrivalOrder;

    /**
     * Signals if current student is waiting for next portion
     */
    private boolean isWaitingForPortion;

    /**
     * Reference to the Table
     */
    private final TableStub table;


    /**
     * Instantiation of Student Thread
     *
     * @param studentId student id
     * @param table reference to the table
     */
    public Student(int studentId, TableStub table) {
        super(String.format("Student %d", studentId));
        this.studentId = studentId;
        this.studentState = StudentStates.GOING_TO_THE_RESTAURANT;
        this.table = table;
        selected = false;
        arrivalOrder = -1;
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
        arrivalOrder = table.enter();
        System.out.printf("DEBUG - Student[%d] arrival order -> %d\n", studentId, arrivalOrder);
        table.readTheMenu();

        // if it's the first student to arrive
        if(arrivalOrder == 1) {
            System.out.printf("DEBUG - Student[%d], come on, let's prepare the orders\n", studentId);
            table.prepareTheOrder();                    // prepares all the orders and signals waiter

            table.hasEverybodyChosen();                 // wait while everyone is choosing
            table.addUpOnesChoice();                    // attend to everyone's orders (first chosen, first served)

            table.callTheWaiter();
            table.describeTheOrder();
            table.joinTheTalk();
        } else
            table.informCompanion();                    // if it is not, informs the first student
                                                        // to arrive of which order he wants


        // starts eating de 0 upto M courses
        for (int i = 0; i < SimulPar.TOTAL_COURSES; i++) {

            table.startEating(i+1);
            boolean lastOneToFinishEating = table.endEating();
            GenericIO.writelnString(String.valueOf(lastOneToFinishEating));

            if (lastOneToFinishEating) {        // if it's the last one eating signals waiter
                table.signalTheWaiter();        // to prepare/serve the next course
            }

        }

        // if is the last student to arrive he pays the bill
        if (arrivalOrder == SimulPar.TOTAL_STUDENTS) {
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
     * Verify if it's the last student to arrive
     *
     * @return last student to arrive flag
     */
    public boolean isLastStudentToArrive() {
        return arrivalOrder == SimulPar.TOTAL_STUDENTS;
    }

    public int getStudentState() {
        return this.studentState;
    }
}
