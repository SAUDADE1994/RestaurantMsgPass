package serverSide.sharedRegions;

/**
 * Actions performed by the waiter in the bar
 */
public interface IBar_Waiter {

    /**
     * Operation say goodby
     *
     * It is called by the waiter when the student as paid de orders
     */
    void sayGoodbye();

    /**
     * Operation prepare the bill
     *
     * It is called by the waiter after signaled that everybody as finished eating
     */
    void prepareTheBill();

}
