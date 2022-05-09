package clientSide.stubs;

/**
 * Actions to be performed by the Chef in the Kitchen
 */
public interface IKitchen_Chef {

    /**
     * Operation watch the news
     *
     * It is called by chef when is waiting for an order
     */
    void watchTheNews();

    /**
     * Operation start preparing
     *
     * It is called by the chef when he starts preparing the dishes
     */
    void startPreparing();

    /**
     * Operation alert the waiter
     *
     * It is called by the chef when a portion is ready to be served
     */
    void alertTheWaiter();

    /**
     * Operation proceed to presentation
     *
     * It is called by the chef while proceeding to dish the portions
     */
    void proceedToPresentation();

    /**
     * Operation have next portion ready
     *
     * It is called by the chef when the portion as been delivered and is preparing the next portion
     */
    void haveNextPortionReady();

    /**
     * Operation continue preparation
     *
     * It is called by chef when all the portions have not been served
     */
    void continuePreparation();

    /**
     * Operation have all portions been served
     *
     * It is called by the chef everytime he is done preparing a portion
     *
     * @return Whether all portions of the course at hand were delivered
     */
    boolean haveAllPortionsBeenDelivered();

    /**
     * Operation had the order been completed
     *
     * It is called by chef when checking if the orders been completed
     *
     * @return Whether all the orders have been cooked and collected
     */
    boolean hasTheOrderBeenCompleted();

    /**
     * Operation clean up
     *
     * It is called by chef when all the courses been served
     */
    void cleanUp();
}
