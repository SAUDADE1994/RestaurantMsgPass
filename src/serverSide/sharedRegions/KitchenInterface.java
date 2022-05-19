package serverSide.sharedRegions;

import commInfra.Message;
import genclass.GenericIO;
import serverSide.entities.Chef;
import serverSide.entities.Student;
import serverSide.entities.Waiter;
import serverSide.main.FunctionsIds;

public class KitchenInterface implements  SharedRegionInterface{

    private Kitchen kitchen;

    private boolean shutdown;

    public KitchenInterface(Kitchen kitchen) {
        this.kitchen = kitchen;
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
            case FunctionsIds.WATCHTHENEWS:
                chef = (Chef) Thread.currentThread();
                chef.setChefId((int) message.getStateFields()[0]);
                chef.setChefState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> SAYGOODBY");
                state = new Object[]{chef.getChefId(), chef.getChefState()};
                break;

            case FunctionsIds.STARTPREPARING:
                chef = (Chef) Thread.currentThread();
                chef.setChefId((int) message.getStateFields()[0]);
                chef.setChefState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> SAYGOODBY");
                state = new Object[]{chef.getChefId(), chef.getChefState()};
                break;
            case FunctionsIds.ALERTWAITER:
                chef = (Chef) Thread.currentThread();
                chef.setChefId((int) message.getStateFields()[0]);
                chef.setChefState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> SAYGOODBY");
                state = new Object[]{chef.getChefId(), chef.getChefState()};
                break;
            case FunctionsIds.PROCEEDTOPRESENTATION:
                chef = (Chef) Thread.currentThread();
                chef.setChefId((int) message.getStateFields()[0]);
                chef.setChefState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> SAYGOODBY");
                state = new Object[]{chef.getChefId(), chef.getChefState()};
                break;
            case FunctionsIds.HAVENEXTPORTIONREADY:
                chef = (Chef) Thread.currentThread();
                chef.setChefId((int) message.getStateFields()[0]);
                chef.setChefState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> SAYGOODBY");
                state = new Object[]{chef.getChefId(), chef.getChefState()};
                break;
            case FunctionsIds.CONTINUEPREPARATION:
                chef = (Chef) Thread.currentThread();
                chef.setChefId((int) message.getStateFields()[0]);
                chef.setChefState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> SAYGOODBY");
                state = new Object[]{chef.getChefId(), chef.getChefState()};
                break;
            case FunctionsIds.HAVEALLPORTIONSBEENDELIVERED:
                chef = (Chef) Thread.currentThread();
                chef.setChefId((int) message.getStateFields()[0]);
                chef.setChefState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> SAYGOODBY");
                state = new Object[]{chef.getChefId(), chef.getChefState()};
                break;
            case FunctionsIds.HASTHEORDERBEENCOMPLETED:
                chef = (Chef) Thread.currentThread();
                chef.setChefId((int) message.getStateFields()[0]);
                chef.setChefState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> SAYGOODBY");
                state = new Object[]{chef.getChefId(), chef.getChefState()};
                break;
            case FunctionsIds.CLEANUP:
                chef = (Chef) Thread.currentThread();
                chef.setChefId((int) message.getStateFields()[0]);
                chef.setChefState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> SAYGOODBY");
                state = new Object[]{chef.getChefId(), chef.getChefState()};
                break;
            case FunctionsIds.SAYGOODBY:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> SAYGOODBY");
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;
            case FunctionsIds.HANDTHENOTETOTHECHEF:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> SAYGOODBY");
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;
            case FunctionsIds.HAVEALLPORTIONSBEENCOLECTED:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> SAYGOODBY");
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;
            case FunctionsIds.LOOKAROUND_KITCHEN:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> SAYGOODBY");
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
