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
        switch (message.getOperation()) {
            case FunctionsIds.SET_CHEF_STATE:
                GenericIO.writelnString("SETCHEFSTATE");
                rp.setChefState((int) message.getParams()[0]);
                break;

            case FunctionsIds.SET_WAITER_STATE:
                GenericIO.writelnString("SETWAITERSTATE");
                rp.setWaiterState((int) message.getParams()[0]);
                break;
            
            case FunctionsIds.SET_STUDENT_STATE:
                GenericIO.writelnString("SETSTUDENTSTATE");
                rp.setStudentState((int) message.getParams()[0], (int) message.getParams()[1]);
                break;

            case FunctionsIds.SET_STUDENT_IDS:
                GenericIO.writelnString("SETSTUDENTIDS");
                rp.setStudentIds((int) message.getParams()[0]);
                break;
            
            case FunctionsIds.SET_N_COURSE:
                GenericIO.writelnString("SETNCOURSE");
                rp.setNextCourse();
                break;
            
            case FunctionsIds.SET_N_PORTION:
                GenericIO.writelnString("SETNCOURSE");
                rp.setnPortion((int) message.getParams()[0]);
                break;

            case FunctionsIds.SHUTDOWN:
                shutdown = true;
                message = null;
                break;

            default:
                throw new IllegalArgumentException();
        }
        return null;
    }

    @Override
    public boolean hasShutdown() {
        return false;
    }
}
