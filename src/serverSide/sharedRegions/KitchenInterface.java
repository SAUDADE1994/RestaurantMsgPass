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
            case FunctionsIds.WATCH_THE_NEWS:
                chef = (Chef) Thread.currentThread();
                chef.setChefId((int) message.getStateFields()[0]);
                chef.setChefState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> WATCHTHENEWS");
                state = new Object[]{chef.getChefId(), chef.getChefState()};
                break;

            case FunctionsIds.START_PREPARING:
                chef = (Chef) Thread.currentThread();
                chef.setChefId((int) message.getStateFields()[0]);
                chef.setChefState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> STARTPREPARING");
                state = new Object[]{chef.getChefId(), chef.getChefState()};
                break;
            case FunctionsIds.ALERT_WAITER:
                chef = (Chef) Thread.currentThread();
                chef.setChefId((int) message.getStateFields()[0]);
                chef.setChefState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> ALERTWAITER");
                state = new Object[]{chef.getChefId(), chef.getChefState()};
                break;
            case FunctionsIds.PROCEED_TO_PRESENTATION:
                chef = (Chef) Thread.currentThread();
                chef.setChefId((int) message.getStateFields()[0]);
                chef.setChefState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> PROCEEDTOPRESENTATION");
                state = new Object[]{chef.getChefId(), chef.getChefState()};
                break;
            case FunctionsIds.HAVE_NEXT_PORTION_READY:
                chef = (Chef) Thread.currentThread();
                chef.setChefId((int) message.getStateFields()[0]);
                chef.setChefState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> HAVENEXTPORTIONREADY");
                state = new Object[]{chef.getChefId(), chef.getChefState()};
                break;
            case FunctionsIds.CONTINUE_PREPARATION:
                chef = (Chef) Thread.currentThread();
                chef.setChefId((int) message.getStateFields()[0]);
                chef.setChefState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> CONTINUEPREPARATION");
                state = new Object[]{chef.getChefId(), chef.getChefState()};
                break;
            case FunctionsIds.HAVE_ALL_PORTIONS_BEEN_DELIVERED:
                chef = (Chef) Thread.currentThread();
                chef.setChefId((int) message.getStateFields()[0]);
                chef.setChefState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> HAVEALLPORTIONSBEENDELIVERED");
                state = new Object[]{chef.getChefId(), chef.getChefState()};
                break;
            case FunctionsIds.HAS_THE_ORDER_BEEN_COMPLETED:
                chef = (Chef) Thread.currentThread();
                chef.setChefId((int) message.getStateFields()[0]);
                chef.setChefState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> HASTHEORDERBEENCOMPLETED");
                state = new Object[]{chef.getChefId(), chef.getChefState()};
                break;
            case FunctionsIds.CLEAN_UP:
                chef = (Chef) Thread.currentThread();
                chef.setChefId((int) message.getStateFields()[0]);
                chef.setChefState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> CLEANUP");
                state = new Object[]{chef.getChefId(), chef.getChefState()};
                break;
            case FunctionsIds.SAY_GOODBYE:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> SAYGOODBY");
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;
            case FunctionsIds.HAND_THE_NOTE_TO_THE_CHEF:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> HANDTHENOTETOTHECHEF");
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;
            case FunctionsIds.HAVE_ALL_PORTIONS_BEEN_COLLECTED:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> HAVEALLPORTIONSBEENCOLECTED");
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;
            case FunctionsIds.LOOK_AROUND_KITCHEN:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> LOOKAROUND_KITCHEN");
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
