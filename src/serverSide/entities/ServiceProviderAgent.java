package serverSide.entities;

import commInfra.ServerCom;

public class ServiceProviderAgent extends Thread implements Chef, Student, Waiter {

    private ServerCom com;

    


    @Override
    public void setChefId(int id) {

    }

    @Override
    public int getChefId() {
        return 0;
    }

    @Override
    public void setChefState(int state) {

    }

    @Override
    public int getChefState() {
        return 0;
    }

    @Override
    public void setStudentId(int id) {

    }

    @Override
    public int getStudentId() {
        return 0;
    }

    @Override
    public void setStudentState(int state) {

    }

    @Override
    public int getStudentState() {
        return 0;
    }

    @Override
    public void setWaiterId(int id) {

    }

    @Override
    public int getWaiterId() {
        return 0;
    }

    @Override
    public void setWaiterState(int state) {

    }

    @Override
    public int getWaiterState() {
        return 0;
    }
}
