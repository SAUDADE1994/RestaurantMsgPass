package serverSide.entities;

/**
 * Definition of the internal states of the waiter during his life cycle.
 */
public class WaiterStates {

    /**
     * blocking state with transition (initial / final state)
     * the waiter is wakened up by one of the following operations: alertThe-
     * Waiter of the chef, enter and exit of all the students, callTheWaiter of
     * the first student to sit at the table, signalTheWaiter of the last student to
     * finish a course and shouldHaveArrivedEarlier of the last student to sit
     * at the table; transition occurs when the last student has left the
     * restaurant
     */
    public static final int APPRAISING_SITUATION = 1;

    /**
     * blocking state
     * the waiter is wakened up by the operation readTheMenu of the student
     */
    public static final int PRESENTING_THE_MENU = 2;

    /**
     * blocking state
     * the waiter is wakened up by the operation describeTheOrder of the student
     */
    public static final int TAKING_THE_ORDER = 3;

    /**
     * blocking state
     * the waiter is wakened up by the operation startPreparation of the chef
     */
    public static final int PLACING_THE_ORDER = 4;

    /**
     * blocking state
     * the waiter is wakened up by the operation haveAllPortionsBeenDelivered of the chef
     */
    public static final int WAITING_FOR_PORTION = 5;

    /**
     * transition state
     */
    public static final int PROCESSING_THE_BILL = 6;

    /**
     *  blocking state
     *  the waiter is wakened up by the operation honorTheBill of the student
     */
    public static final int RECEIVING_PAYMENT = 7;

}
