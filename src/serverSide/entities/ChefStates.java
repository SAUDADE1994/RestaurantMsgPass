package serverSide.entities;

/**
 *    Definition of the internal states of the chef during his life cycle.
 */
public class ChefStates {

    /**
     * blocking state (initial state)
     * the chef is wakened up by the operation handTheNoteToTheChef of the waiter
     */
    public static final int WAITING_FOR_AN_ORDER = 1;

    /**
     * transition state
     */
    public static final int PREPARING_THE_COURSE = 2;

    /**
     * transition state
     */
    public static final int DISHING_THE_PORTIONS = 3;

    /**
     * blocking state
     * the chef is wakened up by the operation collectPortion of the waiter
     */
    public static final int DELIVERING_THE_PORTIONS = 4;

    /**
     * final state
     */
    public static final int CLOSING_SERVICE = 5;
}
