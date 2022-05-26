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
                table.enter();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.READTHEMENY:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> READTHEMENY");
                table.readTheMenu();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.PREPARETHEORDER:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> PREPARETHEORDER");
                table.prepareTheOrder();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.ADDONEUPSCHOICES:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> ADDONEUPSCHOICES");
                table.addUpOnesChoices();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.HASEVERYBODYCHOSEN:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> HASEVERYBODYCHOSEN");
                res = table.hasEverybodyChosen();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.CALLTHEWAITER:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> CALLTHEWAITER");
                table.callTheWaiter();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.DESCRIBETHEORDER:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> DESCRIBETHEORDER");
                table.describeTheOrder();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.JOINTHETALK:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> JOINTHETALK");
                table.joinTheTalk();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.INFORMCOMPANION:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> INFORMCOMPANION");
                table.informCompanion();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.HASEVERYBODYFINISHED:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> HASEVERYBODYFINISHED");
                res = table.hasEverybodyFinished();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.STARTEATING:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> STARTEATING");
                table.startEating((int) message.getParams()[0]);
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.SHOUDLHAVEARRIVEDEARLIER:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> SHOUDLHAVEARRIVEDEARLIERER");
                table.shouldHaveArrivedEarlier();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.HONORTHEBILL:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> HONORTHEBILL");
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

            case FunctionsIds.ENDEATING:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> ENDEATING");
                res = table.endEating();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.SIGNALTHEWAITER:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> SIGNALTHEWAITER");
                table.signalTheWaiter();
                state = new Object[]{student.getStudentId(), student.getStudentState()};
                break;

            case FunctionsIds.SALUTETHECLIENT:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> SALUTETHECLIENT");
                table.saluteTheClient();
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;

            case FunctionsIds.GETTHEPAD:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> GETTHEPAD");
                table.getThePad();
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;

            case FunctionsIds.DELIVERPORTION:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> DELIVERPORTION");
                table.deliverPortion((int) message.getParams()[0]);
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;

            case FunctionsIds.PREPARETHEBILL:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> PREPARETHEBILL");
                table.presentTheBill();
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;

            case FunctionsIds.LOOKAROUND_TABLE:
                waiter = (Waiter) Thread.currentThread();
                waiter.setWaiterId((int) message.getStateFields()[0]);
                waiter.setWaiterState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Waiter -> LOOKAROUND_TABLE");
                table.lookAround();
                state = new Object[]{waiter.getWaiterId(), waiter.getWaiterState()};
                break;

            case FunctionsIds.ASKFORREADYORDERS:
                student = (Student) Thread.currentThread();
                student.setStudentId((int) message.getStateFields()[0]);
                student.setStudentState((int) message.getStateFields()[1]);
                GenericIO.writelnString("Student -> ASKFORREADYORDERS");
                res = table.askForReadyOrders();
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
