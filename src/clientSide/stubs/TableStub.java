package clientSide.stubs;


import clientSide.entities.Chef;
import clientSide.entities.Student;
import clientSide.entities.Waiter;
import commInfra.CommunicationChannel;
import commInfra.Message;

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
        Object[] state_fields = new Object[1];
        state_fields[0] = s.getStudentId();
        state_fields[1] = s.getStudentState();

        /* operation number to be defined */
        Message m_toServer = new Message(16, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        s.setStudentState((Integer) m_fromServer.getStateFields()[1]);
        //boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();

    }

    @Override
    public void readTheMenu() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] = s.getStudentId();
        state_fields[1] = s.getStudentState();

        /* operation number to be defined */
        Message m_toServer = new Message(17, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        s.setStudentState((Integer) m_fromServer.getStateFields()[1]);
        //boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();

    }

    @Override
    public void prepareTheOrder() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] = s.getStudentId();
        state_fields[1] = s.getStudentState();

        /* operation number to be defined */
        Message m_toServer = new Message(18, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        s.setStudentState((Integer) m_fromServer.getStateFields()[1]);
        //boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();

    }

    @Override
    public void addUpOnesChoices(int studentID) {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] = s.getStudentId();
        state_fields[1] = s.getStudentState();

        /* operation number to be defined */
        Message m_toServer = new Message(19, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        s.setStudentState((Integer) m_fromServer.getStateFields()[1]);
        //boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();

    }

    @Override
    public boolean hasEverybodyChosen() {

        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] = s.getStudentId();
        state_fields[1] = s.getStudentState();

        /* operation number to be defined */
        Message m_toServer = new Message(20, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        s.setStudentState((Integer) m_fromServer.getStateFields()[1]);
        boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();
        return result;
    }

    @Override
    public void callTheWaiter() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] = s.getStudentId();
        state_fields[1] = s.getStudentState();

        /* operation number to be defined */
        Message m_toServer = new Message(21, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        s.setStudentState((Integer) m_fromServer.getStateFields()[1]);
        //boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();

    }

    @Override
    public void describeTheOrder() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] = s.getStudentId();
        state_fields[1] = s.getStudentState();

        /* operation number to be defined */
        Message m_toServer = new Message(22, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        s.setStudentState((Integer) m_fromServer.getStateFields()[1]);
        //boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();
    }

    @Override
    public void joinTheTalk() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] = s.getStudentId();
        state_fields[1] = s.getStudentState();

        /* operation number to be defined */
        Message m_toServer = new Message(23, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        s.setStudentState((Integer) m_fromServer.getStateFields()[1]);
        //boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();

    }

    @Override
    public void informCompanion() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] = s.getStudentId();
        state_fields[1] = s.getStudentState();

        /* operation number to be defined */
        Message m_toServer = new Message(24, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        s.setStudentState((Integer) m_fromServer.getStateFields()[1]);
        //boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();

    }

    @Override
    public boolean hasEverybodyFinished() {

        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] = s.getStudentId();
        state_fields[1] = s.getStudentState();

        /* operation number to be defined */
        Message m_toServer = new Message(25, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        s.setStudentState((Integer) m_fromServer.getStateFields()[1]);
        boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();
        return result;
    }

    @Override
    public void startEating(int courseNo) {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] = s.getStudentId();
        state_fields[1] = s.getStudentState();

        /* operation number to be defined */
        Message m_toServer = new Message(26, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        s.setStudentState((Integer) m_fromServer.getStateFields()[1]);
        //boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();
    }

    @Override
    public void shouldHaveArrivedEarlier() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] = s.getStudentId();
        state_fields[1] = s.getStudentState();

        /* operation number to be defined */
        Message m_toServer = new Message(27, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        s.setStudentState((Integer) m_fromServer.getStateFields()[1]);
        //boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();

    }

    @Override
    public void honorTheBill() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] = s.getStudentId();
        state_fields[1] = s.getStudentState();

        /* operation number to be defined */
        Message m_toServer = new Message(28, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        s.setStudentState((Integer) m_fromServer.getStateFields()[1]);
        //boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();
    }

    @Override
    public void exit() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] = s.getStudentId();
        state_fields[1] = s.getStudentState();

        /* operation number to be defined */
        Message m_toServer = new Message(29, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        s.setStudentState((Integer) m_fromServer.getStateFields()[1]);
        //boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();
    }

    @Override
    public boolean endEating() {

        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] = s.getStudentId();
        state_fields[1] = s.getStudentState();

        /* operation number to be defined */
        Message m_toServer = new Message(30, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        s.setStudentState((Integer) m_fromServer.getStateFields()[1]);
        boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();
        return result;
    }

    @Override
    public void signalTheWaiter() {
        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] = s.getStudentId();
        state_fields[1] = s.getStudentState();

        /* operation number to be defined */
        Message m_toServer = new Message(31, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        s.setStudentState((Integer) m_fromServer.getStateFields()[1]);
        //boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();

    }

    @Override
    public void saluteTheClient() {
        Waiter waiter = (Waiter) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] =waiter.getWaiterId();
        state_fields[1] = waiter.getWaiterState();

        /* operation number to be defined */
        Message m_toServer = new Message(32, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        waiter.setWaiterState((Integer) m_fromServer.getStateFields()[1]);
        //boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();

    }

    @Override
    public void getThePad() {
        Waiter waiter = (Waiter) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] =waiter.getWaiterId();
        state_fields[1] = waiter.getWaiterState();

        /* operation number to be defined */
        Message m_toServer = new Message(33, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        waiter.setWaiterState((Integer) m_fromServer.getStateFields()[1]);
        //boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();

    }

    @Override
    public void deliverPortion() {
        Waiter waiter = (Waiter) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] =waiter.getWaiterId();
        state_fields[1] = waiter.getWaiterState();

        /* operation number to be defined */
        Message m_toServer = new Message(34, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        waiter.setWaiterState((Integer) m_fromServer.getStateFields()[1]);
        //boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();

    }

    @Override
    public void presentTheBill() {
        Waiter waiter = (Waiter) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] =waiter.getWaiterId();
        state_fields[1] = waiter.getWaiterState();

        /* operation number to be defined */
        Message m_toServer = new Message(35, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        waiter.setWaiterState((Integer) m_fromServer.getStateFields()[1]);
        //boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();

    }

    @Override
    public void lookAround() {
        Waiter waiter = (Waiter) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] =waiter.getWaiterId();
        state_fields[1] = waiter.getWaiterState();

        /* operation number to be defined */
        Message m_toServer = new Message(36, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        waiter.setWaiterState((Integer) m_fromServer.getStateFields()[1]);
        //boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();
    }

    public Integer[] askForReadyOrders() {

        Student s = (Student) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[1];
        state_fields[0] = s.getStudentId();
        state_fields[1] = s.getStudentState();

        /* operation number to be defined */
        Message m_toServer = new Message(37, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        s.setStudentState((Integer) m_fromServer.getStateFields()[1]);
        Integer[] result = (Integer[]) m_fromServer.getReturnValue();

        com.close ();
        return result;
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

        Message m_toServer = new Message(44, params, 0, state_fields, 0, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        com.close ();
    }
}