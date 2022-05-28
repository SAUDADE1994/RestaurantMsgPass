package serverSide.entities;

import commInfra.Message;
import commInfra.ServerCom;
import serverSide.sharedRegions.SharedRegionInterface;

public class ServiceProviderAgent extends Thread implements Chef, Student, Waiter {

    private ServerCom com;

    private SharedRegionInterface shi;

    /**
     *  Service to be provided.
     */

    /**
     *  Instantiation.
     *
     *     @param com communication channel
     *     @param shi reference to provided service
     */
    public ServiceProviderAgent(ServerCom com, SharedRegionInterface shi) {
        this.com = com;
        this.shi = shi;
    }

    @Override
    public void run() {

        /* service providing */
        Message message = (Message) com.readObject();
        message = shi.processAndReply(message);
        if (message != null) {
            com.writeObject(message);
        }
    }

    /**
     * Chef Id
     */
    private int chefId;

    /**
     * Chef State
     */
    private int chefState;


    @Override
    public void setChefId(int id) {
        this.chefId = id;
    }

    @Override
    public int getChefId() {
        return chefId;
    }

    @Override
    public void setChefState(int state) {
        this.chefState = state;
    }

    @Override
    public int getChefState() {
        return this.chefState;
    }


    /**
     * Student ID
     */
    private int studentId;

    /**
     * Student State
     */
    private int studentState;
    @Override
    public void setStudentId(int id) {
        this.studentId = id;
    }

    @Override
    public int getStudentId() {
        return this.studentId;
    }

    @Override
    public void setStudentState(int state) {
        this.studentState = state;
    }

    @Override
    public int getStudentState() {
        return this.studentState;
    }

    private boolean firstStudentToArrive;

    private boolean lastStudentToArrive;

    private boolean getSelected;

    @Override
    public void setFirstStudentToArrive(boolean b) {
        this.firstStudentToArrive = b;
    }

    @Override
    public void setLastStudentToArrive(boolean b) {
        this.lastStudentToArrive = b;
    }

    @Override
    public boolean getSelected() {
        return this.getSelected;
    }

    @Override
    public boolean isLastStudentToArrive() {
        return this.lastStudentToArrive;
    }

    @Override
    public void setSelected(boolean b) {
        this.getSelected = b;
    }

    private int waiterId;

    private int waiterState;


    @Override
    public void setWaiterId(int id) {
        this.waiterId = id;
    }

    @Override
    public int getWaiterId() {
        return this.waiterId;
    }

    @Override
    public void setWaiterState(int state) {
        this.waiterState = state;
    }

    @Override
    public int getWaiterState() {
        return this.waiterState;
    }

    private int numberOfStudentsArrived;

    @Override
    public void setNumberOfStudentsArrived(int numberOfStudentsArrived) {
        this.numberOfStudentsArrived = numberOfStudentsArrived;
    }
}
