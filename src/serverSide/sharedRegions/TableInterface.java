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
        Student student;
        Object res = null;
        Object[] state;

        switch (message.getOperation()) {
            case FunctionsIds.ENTER:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> ENTER");
                res = table.enter();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.READ_THE_MENU:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> READ_THE_MENU");
                table.readTheMenu();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.PREPARE_THE_ORDER:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> PREPARE_THE_ORDER");
                table.prepareTheOrder();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.ADD_UP_ONES_CHOICE:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> ADD_UP_ONES_CHOICE");
                table.addUpOnesChoice();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.HAS_EVERYBODY_CHOSEN:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> HAS_EVERYBODY_CHOSEN");
                table.hasEverybodyChosen();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.CALL_THE_WAITER:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> CALL_THE_WAITER");
                table.callTheWaiter();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.DESCRIBE_THE_ORDER:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> DESCRIBE_THE_ORDER");
                table.describeTheOrder();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.JOIN_THE_TALK:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> JOIN_THE_TALK");
                table.joinTheTalk();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.INFORM_COMPANION:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> INFORM_COMPANION");
                table.informCompanion();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.START_EATING:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> START_EATING");
                table.startEating((int) message.getParams()[0]);
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.SHOULD_HAVE_ARRIVED_EARLIER:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> SHOULD_HAVE_ARRIVED_EARLIER");
                table.shouldHaveArrivedEarlier();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.HONOR_THE_BILL:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> HONOR_THE_BILL");
                table.honorTheBill();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.EXIT:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> EXIT");
                table.exit();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.END_EATING:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> END_EATING");
                res = table.endEating(((int) message.getParams()[0]));
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.SIGNAL_THE_WAITER:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> SIGNAL_THE_WAITER");
                table.signalTheWaiter();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.SALUTE_THE_CLIENT:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> SALUTE_THE_CLIENT");
                res = table.saluteTheClient();
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;

            case FunctionsIds.GET_THE_PAD:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> GET_THE_PAD");
                table.getThePad();
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;

            case FunctionsIds.DELIVER_PORTION:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> DELIVER_PORTION");
                table.deliverPortion((int) message.getParams()[0]);
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;

            case FunctionsIds.PRESENT_THE_BILL:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> PRESENT_THE_BILL");
                table.presentTheBill();
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;

            case FunctionsIds.PREPARE_THE_BILL:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> PREPARE_THE_BILL");
                table.presentTheBill();
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;

            case FunctionsIds.LOOK_AROUND_TABLE:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> LOOK_AROUND_TABLE");
                table.lookAround();
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;

            case FunctionsIds.SHUTDOWN:
                shutdown = true;
                message = null;
                state = new Object[]{};
                break;

            default:
                throw new IllegalArgumentException(String.format("Function ID %d is not present!", message.getOperation()));
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
