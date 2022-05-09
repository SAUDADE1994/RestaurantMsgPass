package clientSide.entities;


import clientSide.stubs.KitchenStub;
import clientSide.stubs.TableStub;

/**
 *   Chef thread.
 *
 *   Used to simulate the Chef life cycle.
 *   Static solution.
 */
public class Chef extends Thread {

    /**
     * Chef Id
     */
    private int chefId;

    /**
     * Chef State
     */
    private int chefState;

    /**
     * Reference to the Kitchen
     */
    private final KitchenStub kitchen;

    /**
     * Reference to the Table
     */
    private final TableStub table;

    /**
     * Chef is waiting for orders
     */
    private boolean waitingForOrders;

    /**
     * Instantiation of Chef Thread
     *
     * @param chefId chef ID
     * @param kitchen reference to the kitchen
     * @param table reference to the table
     * @param repos reference to the repos
     */
    public Chef(int chefId, KitchenStub kitchen, TableStub table) {
        super(String.format("Chef %d", chefId));
        this.chefId = chefId;
        this.chefState = ChefStates.WAITING_FOR_AN_ORDER;
        this.kitchen = kitchen;
        this.table = table;

        waitingForOrders = true;
    }

    /**
     * Life Cycle of the Chef
     *
     * Starts at the state WAITING_FOR_AN_ORDER (waiting for and order of the waiter)
     * Ends when all courses and portions have been served in the state CLOSING_SERVICE
     */
    @Override
    public void run() {

        kitchen.watchTheNews();

        kitchen.startPreparing();

        // Loop while serving all the courses of the order
        while (true) {

            kitchen.proceedToPresentation();

            // Loop while all the portions of the course have been served
            do {
                // Alert the waiter and give him the portion
                kitchen.alertTheWaiter();

                // Get the next portions ready
                kitchen.haveNextPortionReady();
            } while (!kitchen.haveAllPortionsBeenDelivered());

            // Exit condition
            if (kitchen.hasTheOrderBeenCompleted())
                break;

            // Prepare next course
            kitchen.continuePreparation();
        }

        kitchen.cleanUp();

    }

    /**
     * Get Chef ID
     * @return Chef ID
     */
    public int getChefId() {
        return chefId;
    }

    /**
     * Set Chef ID
     * @param chefId Chef ID
     */
    public void setChefId(int chefId) {
        this.chefId = chefId;
    }

    /**
     * Gets Chef State
     * @return Chef State
     */
    public int getChefState() {
        return chefState;
    }


    /**
     * Sets chef State
     * @param chefState Chef State
     */
    public void setChefState(int chefState) {
        this.chefState = chefState;
    }

    /**
     * Gets isWaitingForOrders flag
     * @return is waiting for orders control flag
     */
    public boolean isWaitingForOrders() {
        return waitingForOrders;
    }

    /**
     * Sets waiting_for_orders flag
     * @param waiting_for_orders
     */
    public void setWaitingForOrders(boolean waiting_for_orders) {
        this.waitingForOrders = waiting_for_orders;
    }
}
