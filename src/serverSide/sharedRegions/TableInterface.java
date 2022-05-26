package serverSide.sharedRegions;

import commInfra.Message;
import genclass.GenericIO;
import serverSide.entities.Chef;
import serverSide.entities.Student;
import serverSide.entities.Waiter;
import serverSide.main.FunctionsIds;

public class TableInterface implements SharedRegionInterface {

    private Table table;

    private boolean shutdown;

    public TableInterface(Table table) {
        this.table = table;
        this.shutdown = hasShutdown();
    }

    @Override
    public Message processAndReply(Message message) {
        Waiter waiter;
        Chef chef;
        Student student;
        Object res = null;
        Object[] state;

        switch (message.getOperation()) {
            case FunctionsIds.ENTER:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> ENTER");
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.READ_THE_MENU:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> READTHEMENY");
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.PREPARE_THE_ORDER:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> PREPARETHEORDER");
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.ADD_UP_ONES_CHOICES:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> ADDONEUPSCHOICES");
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.HAS_EVERYBODY_CHOSEN:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> HASEVERYBODYCHOSEN");
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.CALL_THE_WAITER:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> CALLTHEWAITER");
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.DESCRIBE_THE_ORDER:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> DESCRIBETHEORDER");
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.JOIN_THE_TALK:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> JOINTHETALK");
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.INFORM_COMPANION:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> INFORMCOMPANION");
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.HAS_EVERYBODY_FINISHED:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> HASEVERYBODYFINISHED");
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.START_EATING:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> STARTEATING");
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.SHOULD_HAVE_ARRIVED_EARLIER:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> SHOUDLHAVEARRIVEDEARLIERER");
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.HONOR_THE_BILL:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> HONORTHEBILL");
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.EXIT:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> EXIT");
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.END_EATING:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> ENDEATING");
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.SIGNAL_THE_WAITER:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> SIGNALTHEWAITER");
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.SALUTE_THE_CLIENT:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> SALUTETHECLIENT");
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;

            case FunctionsIds.GET_THE_PAD:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> GETTHEPAD");
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;

            case FunctionsIds.DELIVER_PORTION:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> DELIVERPORTION");
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;

            case FunctionsIds.PREPARE_THE_BILL:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> PREPARETHEBILL");
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;

            case FunctionsIds.LOOK_AROUND_TABLE:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> LOOKAROUND_TABLE");
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;

            case FunctionsIds.ASK_FOR_READY_ORDERS:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> ASKFORREADYORDERS");
                state = new Object[]{student.getStudentId(), student.getStudentState()};
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
