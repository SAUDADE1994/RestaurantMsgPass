package serverSide.sharedRegions;

import commInfra.Message;
import genclass.GenericIO;
import serverSide.main.FunctionsIds;
import serverSide.entities.Chef;
import serverSide.entities.Student;
import serverSide.entities.Waiter;

public class BarInterface implements SharedRegionInterface {


    private Bar bar;

    private boolean shutdown;

    public BarInterface(Bar bar) {
        this.bar = bar;
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
        case FunctionsIds.SAY_GOODBYE:
            waiter = (Waiter) Thread.currentThread();
            waiter.setWaiterId((int) message.getStateFields()[0]);
            waiter.setWaiterState((int) message.getStateFields()[1]);
            GenericIO.writelnString("Waiter -> SAYGOODBY");
            state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
            break;

        case FunctionsIds.PREPARE_THE_BILL:
            waiter = (Waiter) Thread.currentThread();
            waiter.setWaiterId((int) message.getStateFields()[0]);
            waiter.setWaiterState((int) message.getStateFields()[1]);
            GenericIO.writelnString("Waiter -> PREPARETHEBILL");
            state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
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
        return shutdown;
    }
}
