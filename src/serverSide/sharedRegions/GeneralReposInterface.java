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
        Object res = null;
        Object[] state = new Object[2];
        
        switch (message.getOperation()) {
            case FunctionsIds.SETCHEFSTATE:
                GenericIO.writelnString("SETCHEFSTATE");
                rp.setChefState((int) message.getParams()[0]);
                break;

            case FunctionsIds.SETWAITERSTATE:
                GenericIO.writelnString("SETWAITERSTATE");
                rp.setWaiterState((int) message.getParams()[0]);
                break;
            
            case FunctionsIds.SETSTUDENTSTATE:
                GenericIO.writelnString("SETSTUDENTSTATE");
                rp.setStudentState((int) message.getParams()[0], (int) message.getParams()[1]);
                break;

            case FunctionsIds.SETSTUDENTIDS:
                GenericIO.writelnString("SETSTUDENTIDS");
                rp.setStudentIds((int) message.getParams()[0]);
                break;
            
            case FunctionsIds.SETNCOURSE:
                GenericIO.writelnString("SETNCOURSE");
                rp.setNextCourse();
                break;
            
            case FunctionsIds.SETNPORTION:
                GenericIO.writelnString("SETNCOURSE");
                rp.setnPortion((int) message.getParams()[0]);
                break;

            case FunctionsIds.SHUTDOWN:
                shutdown = true;
                message = null;
                state = new Object[]{};
                break;

            default:
                throw new IllegalArgumentException();
        }
        return message;
    }

    @Override
    public boolean hasShutdown() {
        return false;
    }
}
