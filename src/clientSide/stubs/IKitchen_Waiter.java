package clientSide.stubs;

/**
 * Actions to be performed by the Waiter in the Kitchen
 */
public interface IKitchen_Waiter {

    /**
     * Operation hand the note to the chef
     *
     * It is called by waiter after all orders been delivered by the student
     */
    void handTheNoteToTheChef();

    /**
     * Operation have all portions been collected (internal operation of shared region Kitchen)
     *
     * @return True if all portions of the course at hand were collected
     */
    boolean haveAllPortionsBeenCollected();

    /**
     * Operation collect portion
     *
     * It is called by waiter to collect the portions
     */
    void collectPortion();

    /**
     * Operation look around
     *
     * It is called by waiter when waiting for all portions to be ready to be served
     */
    void lookAround();

}
