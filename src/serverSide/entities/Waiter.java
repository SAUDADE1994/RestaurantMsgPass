package serverSide.entities;

public interface Waiter {

    void setWaiterId(int id);

    int getWaiterId();

    void setWaiterState(int state);

    int getWaiterState();

    void setNumberOfStudentsArrived(int numberOfStudentsArrived);
}
