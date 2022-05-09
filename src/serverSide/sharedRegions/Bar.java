package serverSide.sharedRegions;


import serverSide.entities.Waiter;
import serverSide.entities.WaiterStates;

/**
* Bar
*
* It is responsible to control the waiter in order to prepare the bill and say goodbye to the students
* Is implemented using as an implicit monitor
*/
public class Bar implements IBar_Waiter {

    /**
     * Singleton instance of this class
     */
    private static Bar instance;

    /**
     * @return the singleton instance of this class
     */
    public static Bar getInstance() {
        if (instance == null) {
            instance = new Bar();
        }
        return instance;
    }


    @Override
    public void sayGoodbye() {
        System.out.println("Waiter is saying goodbye to the student customers");
    }

    @Override
    public void prepareTheBill() {

        ((Waiter) Thread.currentThread()).setWaiterState(WaiterStates.PROCESSING_THE_BILL);

        // Sleep
        try {
            Thread.sleep(50L);
        } catch (InterruptedException ignored) {
        }

        System.out.println("Waiter is processing the bill");

    }
}