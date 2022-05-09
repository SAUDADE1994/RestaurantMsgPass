package clientSide.entities;

import clientSide.main.SimulPar;
import clientSide.stubs.BarStub;
import clientSide.stubs.KitchenStub;
import clientSide.stubs.TableStub;


/**
 *   Waiter thread.
 *
 *   Used to simulate the Waiter life cycle.
 *   Static solution.
 */
public class Waiter extends Thread {

    /**
     * Waiter id
     */
    private int waiterId;

    /**
     * Wiater state
     */
    private int waiterState;

    /**
     * Reference to the kitchen
     */
    private final KitchenStub kitchen;

    /**
     * Reference to the Table
     */
    private final TableStub table;

    /**
     * Reference to the Bar
     */
    private final BarStub bar;

    /**
     * Variable counting the number of students arriving
     */
    private int numberOfStudentsArrived;

    /**
     * Variable counting the number of portions served
     */
    private int portionsServerd;

    /**
     * Flag controlling if all orders are chosen
     */
    private boolean allOrdersChosen;

    /**
     *
     * @param waiterId waiters id
     * @param bar bar reference
     * @param kitchen kitchen reference
     * @param table table reference
     */
    public Waiter(int waiterId, BarStub bar, KitchenStub kitchen, TableStub table) {
        super(String.format("Waiter %d", waiterId));
        this.waiterId = waiterId;
        this.waiterState = WaiterStates.APPRAISING_SITUATION;
        this.bar = bar;
        this.kitchen = kitchen;
        this.table = table;

        portionsServerd = 0;
        numberOfStudentsArrived = 0;
        allOrdersChosen = false;
    }

    /**
     * Sets waiter state and updates repository
     * @param waiterState waiter state
     */
    public void setWaiterState(int waiterState) {
        this.waiterState = waiterState;
    }

    public int getWaiterState() { return this.waiterState; }

    public int getWaiterId() {
        return this.waiterId;
    }


    /**
     * Life Cycle of the Waiter
     *
     * Starts at the state WAITING_FOR_AN_ORDER (waiting for and order of the waiter)
     * Ends when all courses and portions have been served in the state CLOSING_SERVICE
     */
    @Override
    public void run() {
        // Salutes all students upon arrival
        // First Cycle
        while(getNumberOfStudentsArrived() != SimulPar.TOTAL_STUDENTS) {
            table.saluteTheClient();
            returnToTheBar("Table");
        }

        table.getThePad();
        kitchen.handTheNoteToTheChef();

        for (int i = 0; i < SimulPar.TOTAL_COURSES; i++) {
            // Look around in the kitchen for next course
            returnToTheBar("Kitchen");
            //repos.setnCourse(i+1);

            portionsServerd = 0;
            while (!kitchen.haveAllPortionsBeenCollected()){
                kitchen.collectPortion();
                table.deliverPortion();
                //repos.setnPortion(++portionsServerd);
            }

            // Look around in the table region for when the students are finished
            returnToTheBar("Table");
        }

        // Wait for when students are ready for payment
        returnToTheBar("Table");

        bar.prepareTheBill();
        table.presentTheBill();

        bar.sayGoodbye();
    }

    /**
     * Waiter returns to the bar and looks arround
     */
    public void returnToTheBar(String nextRegion) {

        try {
            sleep ((long) (1 + 25 * Math.random ()));
        }
        catch (InterruptedException ignored) {}
        setWaiterState(WaiterStates.APPRAISING_SITUATION);

        // Look around at the next region where the waiter will be called
        lookAround(nextRegion);
    }

    /**
     * waiter is looking around the bar
     * @param region region from where is returning to the bar
     */
    public void lookAround(String region) {
        switch (region) {
            case "Kitchen":
                kitchen.lookAround();
                break;
            case "Bar":
//                bar.lookAround();
                break;
            case "Table":
                table.lookAround();
                break;
        }
    }

    /**
     * Gets the number of students that arrive
     * @return number of students arrived
     */
    public int getNumberOfStudentsArrived() {
        return numberOfStudentsArrived;
    }

    /**
     * Sets the number of students that arrive
     * @param numberOfStudentsArrived number of students arrived
     */
    public void setNumberOfStudentsArrived(int numberOfStudentsArrived) {
        this.numberOfStudentsArrived = numberOfStudentsArrived;
    }
}
