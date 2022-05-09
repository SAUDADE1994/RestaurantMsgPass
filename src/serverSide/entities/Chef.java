package serverSide.entities;

public interface Chef {

    void setChefId(int id);

    int getChefId();

    void setChefState(int state);

    int getChefState();

    boolean isWaitingForOrders();

    void setWaitingForOrders(boolean b);
}
