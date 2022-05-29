package serverSide.sharedRegions;

import commInfra.MemException;
import commInfra.MemFIFO;
import serverSide.entities.Chef;
import serverSide.entities.ChefStates;
import serverSide.entities.Waiter;
import serverSide.entities.WaiterStates;
import serverSide.main.SimulPar;
import serverSide.stubs.GeneralReposStub;

import static java.lang.Thread.sleep;

/**
 * Kitchen
 *
 * It is responsible to prepare the portions of each course by the chef
 * Is implemented using as an implicit monitor
 */
public class Kitchen implements IKitchen_Chef, IKitchen_Waiter {

    private final GeneralReposStub repos;

    /**
     * Flag is true only after the chef has started working
     */
    private boolean chefStartWorking;

    /**
     * This variable indicated that the waiter is able to collect a portion at the moment
     */
    private boolean oneMorePortionReady;

    /**
     * Flag indicating, for each portion of the course at hand,
     *  whether it was collected by the waiter
     */
    private MemFIFO<Boolean> portionsCollected;

    /**
     * Number of courses that have been fully delivered to the waiter
     */
    private byte coursesDelivered;

    /**
     * Chef is waiting for orders
     */
    private boolean waitingForOrders;

    /**
     * Flag to signal that the waiter is ready for next course
     * (enforces that the chef and waiter are in the same course cycle)
     */
    private boolean waiterWrapUpCourse;

    /**
     * Private constructor of Kitchen
     */
    public Kitchen(GeneralReposStub repos) {
        this.repos = repos;
        chefStartWorking = false;
        oneMorePortionReady = false;
        waitingForOrders = true;
        coursesDelivered = 0;
        waiterWrapUpCourse = false;

        // FIFO initializations
        try {
            portionsCollected = new MemFIFO<>(new Boolean[SimulPar.TOTAL_STUDENTS * SimulPar.TOTAL_COURSES]);
        } catch (MemException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    @Override
    public synchronized void watchTheNews() {
        while(waitingForOrders) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public synchronized void proceedToPresentation() {

        ((Chef) Thread.currentThread()).setChefState(ChefStates.DISHING_THE_PORTIONS);
        repos.setChefState(ChefStates.DISHING_THE_PORTIONS);

        try
        {
            sleep ((long) (1 + 30 * Math.random ()));
        }
        catch (InterruptedException ignored) {}
    }

    @Override
    public synchronized void haveNextPortionReady() {

        // Sleep for a bit
        try
        {
            sleep ((long) (1 + 10 * Math.random ()));
        }
        catch (InterruptedException ignored) {}

        // Set next state to dishing the portions
        ((Chef) Thread.currentThread()).setChefState(ChefStates.DISHING_THE_PORTIONS);
        repos.setChefState(ChefStates.DISHING_THE_PORTIONS);
    }


    @Override
    public synchronized void alertTheWaiter() {

        // Set state to delivering the portions
        ((Chef) Thread.currentThread()).setChefState(ChefStates.DELIVERING_THE_PORTIONS);
        repos.setChefState(ChefStates.DELIVERING_THE_PORTIONS);

        // Set flag in order to alert the waiter next portion is ready
        oneMorePortionReady = true;
        notifyAll();

        // Wait until the waiter collects the portion
        while (oneMorePortionReady) {
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }
    }

    @Override
    public synchronized void startPreparing() {
        chefStartWorking = true;
        notifyAll();
    }

    @Override
    public synchronized void continuePreparation() {
        ((Chef) Thread.currentThread()).setChefState(ChefStates.PREPARING_THE_COURSE);
        repos.setChefState(ChefStates.PREPARING_THE_COURSE);

        while (!waiterWrapUpCourse) {
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }

        waiterWrapUpCourse = false;

        // Completed one more course
        if (coursesDelivered < SimulPar.TOTAL_COURSES)
            coursesDelivered++;
    }

    @Override
    public synchronized boolean haveAllPortionsBeenDelivered() {

        int totalPortions = SimulPar.TOTAL_STUDENTS * (coursesDelivered + 1);

        if (totalPortions < portionsCollected.getN())
            throw new IllegalStateException(
                    String.format("At the course %d, there were delivered %d portions?", coursesDelivered, portionsCollected.getN())
            );

        // Check if all portions were collected by the waiter
        return portionsCollected.getN() == totalPortions;
    }

    @Override
    public synchronized boolean hasTheOrderBeenCompleted() {
        return portionsCollected.full();
    }

    @Override
    public synchronized void collectPortion() {
        // Set state to waiting for portion
        ((Waiter) Thread.currentThread()).setWaiterState(WaiterStates.WAITING_FOR_PORTION);
        repos.setWaiterState(WaiterStates.WAITING_FOR_PORTION);

        // Wait for portion
        while (!oneMorePortionReady) {
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }

        // Collect one more portion
        try {
            portionsCollected.write(true);
        } catch (MemException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Collected portion, next portion is by default not ready
        oneMorePortionReady = false;

        notifyAll();
    }


    @Override
    public void cleanUp() {
        // Set the state to closing service
        ((Chef) Thread.currentThread()).setChefState(ChefStates.CLOSING_SERVICE);
        repos.setChefState(ChefStates.CLOSING_SERVICE);

    }

    @Override
    public synchronized void handTheNoteToTheChef() {
        ((Waiter) Thread.currentThread()).setWaiterState(WaiterStates.PLACING_THE_ORDER);
        repos.setWaiterState(WaiterStates.PLACING_THE_ORDER);

        waitingForOrders = false;
        notifyAll();

        while (!chefStartWorking) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ((Waiter) Thread.currentThread()).setWaiterState((WaiterStates.APPRAISING_SITUATION));
        repos.setWaiterState(WaiterStates.APPRAISING_SITUATION);
    }

    @Override
    public synchronized boolean haveAllPortionsBeenCollected() {

        int totalPortions = SimulPar.TOTAL_STUDENTS * (coursesDelivered+1);

        // Check if all portions were collected by the waiter
        if (portionsCollected.getN() < totalPortions)
            return false;

        waiterWrapUpCourse = true;
        notifyAll();
        return true;

    }

    @Override
    public synchronized void lookAround() {

        notifyAll();

        while (!oneMorePortionReady) {
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }

    }
}