package serverSide.sharedRegions;

import java.util.zip.ZipException;

import commInfra.Message;
import genclass.GenericIO;
import serverSide.entities.Chef;
import serverSide.entities.Student;
import serverSide.entities.Waiter;
import serverSide.main.FunctionsIds;

public class GeneralReposInterface implements SharedRegionInterface {

    private GeneralRepos rp;

    private boolean shutdown;


    public GeneralReposInterface(GeneralRepos rp) {
        this.rp = rp;
        this.shutdown = false;
    }

    @Override
    public Message processAndReply(Message message) {
        Waiter waiter;
        Chef chef;
        Student student;
        Object res = null;
        Object[] state;
        
        switch (message.getOperation()) {
            case FunctionsIds.SETCHEFSTATE:
                chef = (Chef) Thread.currentThread();
                chef.setChefId((int) message.getStateFields()[0]);
                chef.setChefState((int) message.getStateFields()[1]);
                GenericIO.writelnString("SETCHEFSTATE");
                rp.setChefState();
                state = new Object[]{chef.getChefId(), chef.getChefState()};
                break;

            case FunctionsIds.SETWAITERSTATE:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("SETWAITERSTATE");
                rp.setWaiterState((int) message.getStateFields()[1]);
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;
            
            case FunctionsIds.SETSTUDENTSTATE:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("SETSTUDENTSTATE");
                rp.setStudentState((int) message.getStateFields()[0], (int) message.getStateFields()[1]);
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.SETSTUDENTIDS:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("SETSTUDENTIDS");
                rp.setStudentIds((int) message.getStateFields()[0]);
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;
            
            case FunctionsIds.SETNCOURSE:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("SETNCOURSE");
                rp.setNextCourse();
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;
            
            case FunctionsIds.SETNPORTION:
                GenericIO.writelnString("SETNCOURSE");
                rp.setnPortion((int) message.getStateFields()[0]);
                break;

            case FunctionsIds.SHUTDOWN:
                shutdown = true;
                message = null;
                state = new Object[]{};
                break;

            default:
                throw new IllegalArgumentException();
        }

        if (message != null) {
            message.setStateFields(state);
            message.setSizeStateFields(state.length);
            message.setReturnValue(res);
        }
        return message;
    }

    @Override
    public boolean hasShutdown() {
        return false;
    }
}
