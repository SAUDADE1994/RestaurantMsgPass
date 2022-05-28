package serverSide.entities;

public interface Student {

    void setStudentId(int id);

    int getStudentId();

    int getArrivalOrder();

    void setArrivalOrder(int arrivalOrder);

    void setStudentState(int state);

    int getStudentState();

    boolean isLastStudentToArrive();

}
