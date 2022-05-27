package clientSide.stubs;

import clientSide.entities.Waiter;
import commInfra.CommunicationChannel;
import commInfra.Message;
import serverSide.main.FunctionsIds;

public class BarStub implements IBar_Waiter {

    String serverHostName;

    int serverPortNumb;

    public BarStub(String serverName, int port) {
        serverHostName = serverName;
        serverPortNumb = port;
    }


    @Override
    public void sayGoodbye() {
        Waiter waiter = (Waiter) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[2];
        state_fields[0] =waiter.getWaiterId();
        state_fields[1] = waiter.getWaiterState();

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.SAY_GOODBYE, params, state_fields, null);
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
    public void prepareTheBill() {
        Waiter waiter = (Waiter) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[2];
        state_fields[0] =waiter.getWaiterId();
        state_fields[1] = waiter.getWaiterState();

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.PREPARE_THE_BILL, params, state_fields, null);
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

    /**
     *
     *Method called to shutdown the Bar server
     *
     */

    public void shutdown() {
        CommunicationChannel com = new CommunicationChannel (serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[1];

        Message m_toServer = new Message(FunctionsIds.SHUTDOWN, params, state_fields, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep (10L);
        }
        catch (InterruptedException ignored) {}
        }

        com.writeObject (m_toServer);

        com.close ();
    }
}