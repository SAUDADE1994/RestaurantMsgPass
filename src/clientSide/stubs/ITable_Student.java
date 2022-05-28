package clientSide.stubs;

/**
 * Actions to be performed by the students in the Table
 */
public interface ITable_Student {

    /**
     * Operation enter the restaurant
     *
     * It is called by a student when he enters the restaurant
     *
     * @return order in which the student arrived (1 for the first, etc.)
     */
    int enter();

    /**
     * Operation read the menu
     *
     * The student reads the menu after waiting for the hostess to salute him
     */
    void readTheMenu();

    /**
     * Operation prepare the order
     *
     * It is called by the first student to arrive the restaurant when every other student as arrived
     */
    void prepareTheOrder();

    /**
     * Operation add up ones choices
     *
     * It is called by student while is waiting for all students to choose
     */
    void addUpOnesChoice();

    /**
     * Operation Has every body choosen
     *
     * It is called by student when every student as chosen the order
     *
     */
    void hasEverybodyChosen();

    /**
     * Operation call the waiter
     *
     * It is called by the first student to arrive when everybody as chosen is menus
     */
    void callTheWaiter();

    /**
     * Operation describe the order
     *
     * It is called by students when is describing the order to the waiter
     */
    void describeTheOrder();

    /**
     * Operation join the talk
     *
     * It is called by the students after choosing the menu
     */
    void joinTheTalk();

    /**
     * Operation inform companion
     *
     * It is called by student when he as chosen the menu
     */
    void informCompanion();

    /**
     * Operation start eating
     *
     * It is called by students when the portions of each course arrive
     *
     * @param courseNo Ordinal number of the course - N when the course is the Nth to be served
     */
    void startEating(int courseNo);

    /**
     * Operation should arrived earlier
     *
     * It is called by the student when it's the last one to arrive
     */
    void shouldHaveArrivedEarlier();

    /**
     * Operation Honor the bill
     *
     * It is called by the last student to arrive to pay the bill
     */
    void honorTheBill();

    /**
     * Operation exit
     *
     * It is called by the students when they finished eating and the billing is concluded
     */
    void exit();

    /**
     * Operation end eating
     *
     * @param courseNo Number of the course which is currently being finished by students
     *
     * It is called by students while they eat
     */
	boolean endEating(int courseNo);

    /**
     * Operation signal the waiter
     *
     * It is called by the first student to arrive when all finished eating
     */
    void signalTheWaiter();
}
