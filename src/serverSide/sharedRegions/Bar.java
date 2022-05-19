package serverSide.sharedRegions;


import serverSide.entities.Waiter;
import serverSide.entities.WaiterStates;
import serverSide.stubs.GeneralReposStub;

/**
* Bar
*
* It is responsible to control the waiter in order to prepare the bill and say goodbye to the students
* Is implemented using as an implicit monitor
*/
public class Bar implements IBar_Waiter {

    /**
     *   Reference to the General Repository.
     */

    private final GeneralReposStub repos;

    public Bar(GeneralReposStub generalReposStub) {
        this.repos = generalReposStub;
    }

    @Override
    public void sayGoodbye() {
        System.out.println("Waiter is saying goodbye to the student customers");
    }

    @Override
    public void prepareTheBill() {

        ((Waiter) Thread.currentThread()).setWaiterState(WaiterStates.PROCESSING_THE_BILL);
        repos.setWaiterState(WaiterStates.PROCESSING_THE_BILL);

        // Sleep
        try {
            Thread.sleep(50L);
        } catch (InterruptedException ignored) {
        }

        System.out.println("Waiter is processing the bill");

    }
}