package clientSide.stubs;

/**
 * Actions to be performed by the Waiter in the Table
 */
public interface ITable_Waiter {

    /**
     * Operation salute the client
     *
     * It is called by the waiter when students arrive
     */
    void saluteTheClient();

    /**
     * Operation get the pad
     *
     * It is called by the waiter when the first student to arrive signals waiter that is ready
     * to present the orders
     */
    void getThePad();

    /**
     * Operation deliver portion
     *
     * It is called by waiter when the portions are ready to deliver
     */
    void deliverPortion(int portionsServed);

    /**
     * Operation present billing
     *
     * It is called by waiter when its signaled to present the bill
     */
    void presentTheBill();

    /**
     * Operation look around
     *
     * It is called by waiter when returns to the bar
     */
    void lookAround();


}
