package clientSide.stubs;


import clientSide.entities.Student;
import clientSide.entities.Waiter;
import commInfra.CommunicationChannel;
import commInfra.Message;
import serverSide.main.FunctionsIds;

public class TableStub implements ITable_Student, ITable_Waiter {

    String serverHostName;

    int serverPortNumb;

    public TableStub(String hostName, int port) {
        serverHostName = hostName;
        serverPortNumb = port;
    }

    @Override
    public void enter() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[]{
                s.getStudentId(),
                s.getStudentState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.ENTER, params, state_fields, null);

        vStudentCallFunctionMsg(s, com, m_toServer);

    }

    @Override
    public void readTheMenu() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[]{
                s.getStudentId(),
                s.getStudentState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.READ_THE_MENU, params, state_fields, null);
        vStudentCallFunctionMsg(s, com, m_toServer);

    }

    @Override
    public void prepareTheOrder() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[]{
                s.getStudentId(),
                s.getStudentState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.PREPARE_THE_ORDER, params, state_fields, null);
        vStudentCallFunctionMsg(s, com, m_toServer);

    }

    @Override
    public void addUpOnesChoice() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[]{};
        Object[] state_fields = new Object[]{
                s.getStudentId(),
                s.getStudentState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.ADD_UP_ONES_CHOICE, params, state_fields, null);
        vStudentCallFunctionMsg(s, com, m_toServer);

    }

    @Override
    public void hasEverybodyChosen() {

        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[]{
                s.getStudentId(),
                s.getStudentState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.HAS_EVERYBODY_CHOSEN, params, state_fields, null);
        vStudentCallFunctionMsg(s, com, m_toServer);
    }

    @Override
    public void callTheWaiter() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[]{
                s.getStudentId(),
                s.getStudentState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.CALL_THE_WAITER, params, state_fields, null);
        vStudentCallFunctionMsg(s, com, m_toServer);

    }

    @Override
    public void describeTheOrder() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[]{
                s.getStudentId(),
                s.getStudentState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.DESCRIBE_THE_ORDER, params, state_fields, null);
        vStudentCallFunctionMsg(s, com, m_toServer);
    }

    @Override
    public void joinTheTalk() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[]{
                s.getStudentId(),
                s.getStudentState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.JOIN_THE_TALK, params, state_fields, null);
        vStudentCallFunctionMsg(s, com, m_toServer);

    }

    @Override
    public void informCompanion() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[]{
                s.getStudentId(),
                s.getStudentState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.INFORM_COMPANION, params, state_fields, null);
        vStudentCallFunctionMsg(s, com, m_toServer);

    }

    @Override
    public boolean hasEverybodyFinished() {

        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[]{
                s.getStudentId(),
                s.getStudentState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.HAS_EVERYBODY_FINISHED, params, state_fields, null);
        return (boolean) studentCallFunctionMsg(s, com, m_toServer);
    }

    @Override
    public void startEating(int courseNo) {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[] {courseNo};
        Object[] state_fields = new Object[]{
                s.getStudentId(),
                s.getStudentState()
        };
        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.START_EATING, params, state_fields, null);
        vStudentCallFunctionMsg(s, com, m_toServer);
    }

    @Override
    public void shouldHaveArrivedEarlier() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[]{
                s.getStudentId(),
                s.getStudentState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.SHOULD_HAVE_ARRIVED_EARLIER, params, state_fields, null);
        vStudentCallFunctionMsg(s, com, m_toServer);

    }

    @Override
    public void honorTheBill() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[]{
                s.getStudentId(),
                s.getStudentState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.HONOR_THE_BILL, params, state_fields, null);
        vStudentCallFunctionMsg(s, com, m_toServer);
    }

    @Override
    public void exit() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[]{
                s.getStudentId(),
                s.getStudentState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.EXIT, params, state_fields, null);
        vStudentCallFunctionMsg(s, com, m_toServer);
    }

    @Override
    public boolean endEating() {

        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[]{
                s.getStudentId(),
                s.getStudentState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.END_EATING, params, state_fields, null);
        return (boolean) studentCallFunctionMsg(s, com, m_toServer);
    }

    @Override
    public void signalTheWaiter() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[]{
                s.getStudentId(),
                s.getStudentState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.SIGNAL_THE_WAITER, params, state_fields, null);
        vStudentCallFunctionMsg(s, com, m_toServer);

    }

    private void vStudentCallFunctionMsg(Student s, CommunicationChannel com, Message m_toServer) {
        studentCallFunctionMsg(s, com, m_toServer);
    }

    @Override
    public void saluteTheClient() {
        Waiter waiter = (Waiter) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[]{
                waiter.getWaiterId(),
                waiter.getWaiterState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.SALUTE_THE_CLIENT, params, state_fields, null);
        waiterCallFunctionMsg(com, m_toServer, waiter);

    }

    @Override
    public void getThePad() {
        Waiter waiter = (Waiter) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[]{
                waiter.getWaiterId(),
                waiter.getWaiterState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.GET_THE_PAD, params, state_fields, null);
        waiterCallFunctionMsg(com, m_toServer, waiter);

    }

    @Override
    public void deliverPortion(int portionsServed) {
        Waiter waiter = (Waiter) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[] {portionsServed};
        Object[] state_fields = new Object[]{
                waiter.getWaiterId(),
                waiter.getWaiterState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.DELIVER_PORTION, params,
                state_fields, null);
        waiterCallFunctionMsg(com, m_toServer, waiter);

    }

    private void waiterCallFunctionMsg(CommunicationChannel com, Message m_toServer, Waiter waiter) {
        Message m_fromServer;

        while (!com.open ()) {
            try {
                Thread.currentThread ().sleep (10L);
            } catch (InterruptedException ignored) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        waiter.setWaiterState((int) m_fromServer.getStateFields()[1]);
        //boolean result = (boolean) m_fromServer.getReturnValue();

        com.close ();
    }

    @Override
    public void presentTheBill() {
        Waiter waiter = (Waiter) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[]{
                waiter.getWaiterId(),
                waiter.getWaiterState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.PRESENT_THE_BILL, params, state_fields, null);
        waiterCallFunctionMsg(com, m_toServer, waiter);

    }

    @Override
    public void lookAround() {
        Waiter waiter = (Waiter) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[]{
                waiter.getWaiterId(),
                waiter.getWaiterState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.LOOK_AROUND_TABLE, params, state_fields, null);
        waiterCallFunctionMsg(com, m_toServer, waiter);
    }

    public int[] askForReadyOrders() {

        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[]{
                s.getStudentId(),
                s.getStudentState()
        };

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.ASK_FOR_READY_ORDERS, params, state_fields, null);

        return  (int[]) studentCallFunctionMsg(s, com, m_toServer);
    }

    private Object studentCallFunctionMsg(Student s, CommunicationChannel com, Message m_toServer) {
        Message m_fromServer;

        while (!com.open ()) {
            try {
                Thread.currentThread ().sleep (10L);
            } catch (InterruptedException ignored) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        s.setStudentState((int) m_fromServer.getStateFields()[1]);

        Object returnVal = m_fromServer.getReturnValue();

        com.close();

        return returnVal;
    }


    /**
     *
     *Method called to shutdown the table server
     *
     */

    public void shutdown() {
        CommunicationChannel com = new CommunicationChannel (serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[0];

        Message m_toServer = new Message(FunctionsIds.SHUTDOWN, params, state_fields, null);

        while (!com.open ()) {
            try {
                Thread.currentThread ().sleep (10L);
            } catch (InterruptedException ignored) {}
        }

        com.writeObject (m_toServer);

        com.close ();
    }
}