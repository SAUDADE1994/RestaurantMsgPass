package serverSide.entities;

import clientSide.main.SimulPar;
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
    public int getArrivalOrder() {
        return arrivalOrder;
    }

    @Override
    public void setArrivalOrder(int arrivalOrder) {
        this.arrivalOrder = arrivalOrder;
    }

    @Override
    public void setStudentState(int state) {
        this.studentState = state;
    }

    @Override
    public int getStudentState() {
        return this.studentState;
    }

    private int arrivalOrder;

    @Override
    public boolean isLastStudentToArrive() {
        return this.arrivalOrder == SimulPar.TOTAL_STUDENTS;
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
