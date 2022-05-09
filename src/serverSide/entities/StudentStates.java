package serverSide.entities;

/**
 * Definition of the internal states of the student during his life cycle.
 */
public class StudentStates {

    /**
     * transition state with random time (initial state)
     */
    public static final int GOING_TO_THE_RESTAURANT = 1;

    /**
     * blocking state
     * the student is wakened up by the operation saluteTheClient of the waiter
     */
    public static final int TAKING_A_SEAT_AT_THE_TABLE = 2;

    /**
     * transition state
     */
    public static final int SELECTING_THE_COURSES = 3;

    /**
     * blocking state
     * the student is waken up by the operation informCompanion of another
     * student and, when all students are already at the table, by the
     * operation getThePad of the waiter
     */
    public static final int ORGANIZING_THE_ORDER = 4;


    /**
     * blocking state with transition
     * the student blocks while waiting for a course to be served and
     * when he/she has finished eating it; transition occurs when the
     * last course has been served and eaten
     */
    public static final int CHATTING_WITH_COMPANIONS = 5;

    /**
     * transition state with random time
     */
    public static final int ENJOYING_THE_MEAL = 6;

    /**
     * blocking state
     * the student is waken up by the operation presentTheBill of the waiter
     */
    public static final int PAYING_THE_BILL = 7;

    /**
     * final state
     */
    public static final int GOING_HOME = 8;
}
