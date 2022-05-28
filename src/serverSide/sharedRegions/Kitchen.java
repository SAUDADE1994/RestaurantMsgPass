package serverSide.sharedRegions;

import serverSide.entities.ChefStates;
import serverSide.entities.Waiter;
import serverSide.entities.WaiterStates;
import serverSide.main.SimulPar;
import serverSide.entities.Chef;
import serverSide.stubs.GeneralReposStub;

import static java.lang.Thread.sleep;

/**
 * Kitchen
 *
 * It is responsible to prepare the portions of each course by the chef
 * Is implemented using as an implicit monitor
 */
public class Kitchen implements IKitchen_Chef, IKitchen_Waiter {
    /**
     *   Reference to the General Repository.
     */
    private static Kitchen instance;

    /**
     * Reference to the chef of the kitchen
     */
    private Chef chef;

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
     * Flag is true when the chef is calling the waiter to collect the next portion
     */
    private boolean isNextPortionReady;

    /**
     * Flag indicating, for each portion of the course at hand,
     *  whether it was collected by the waiter
     */
    private boolean[] arePortionsCollected;

    /**
     * Number of courses that have been fully delivered to the waiter
     */
    private byte coursesDelivered;

    /**
     * Chef is waiting for orders
     */
    private boolean waitingForOrders;

    /**
     * Private constructor of Kitchen
     */
    public Kitchen(GeneralReposStub repos) {
        this.repos = repos;
        chef = null;
        chefStartWorking = false;
        oneMorePortionReady = false;
        isNextPortionReady = false;
        waitingForOrders = true;
        coursesDelivered = 0;
        arePortionsCollected = new boolean[SimulPar.TOTAL_STUDENTS];
    }


    @Override
    public synchronized void watchTheNews() {
        chef = (Chef) Thread.currentThread();
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

        if (!isNextPortionReady)
            isNextPortionReady = true;

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
    }

    @Override
    public synchronized boolean haveAllPortionsBeenDelivered() {

        boolean allPortionsDelivered = true;
        // Check if all portions were collected by the waiter
        for (boolean portionWasCollected : arePortionsCollected) {
            if (!portionWasCollected) {
                allPortionsDelivered = false;
                break;
            }
        }

        if (allPortionsDelivered) {
            // Reset portions status (for next course)
            arePortionsCollected = new boolean[SimulPar.TOTAL_STUDENTS];
            // Completed one more course
            coursesDelivered++;
            // Beginning next course - Naturally, it is not ready right away
            isNextPortionReady = false;
            return true;
        }

        return false;
    }

    @Override
    public synchronized boolean hasTheOrderBeenCompleted() {
        return coursesDelivered == SimulPar.TOTAL_COURSES;
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

        // Collect one more portion (random selection from array, for now)
        for (int i = 0; i < arePortionsCollected.length; i++) {
            // If portion was not yet collected, collect it and break loop
            if (!arePortionsCollected[i]) {
                arePortionsCollected[i] = true;
                break;
            }
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
    public boolean haveAllPortionsBeenCollected() {
        // Check if all portions were collected by the waiter
        for (boolean portionWasCollected : arePortionsCollected) {
            if (!portionWasCollected) {
                return false;
            }
        }
        return true;
    }

    @Override
    public synchronized void lookAround() {
        while (!isNextPortionReady) {
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }

    }
}