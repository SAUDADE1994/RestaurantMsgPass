package serverSide.entities;

public interface Student {

    void setStudentId(int id);

    int getStudentId();

    void setStudentState(int state);

    int getStudentState();

    void setFirstStudentToArrive(boolean b);

    void setLastStudentToArrive(boolean b);

    boolean getSelected();

    boolean isLastStudentToArrive();

    void setSelected(boolean b);
}
