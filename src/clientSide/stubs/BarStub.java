package clientSide.stubs;

import clientSide.entities.Waiter;
import commInfra.CommunicationChannel;
import commInfra.Message;

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
        Message m_toServer = new Message(1, params, state_fields, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
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
        Message m_toServer = new Message(2, params, state_fields, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
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

        Message m_toServer = new Message(44, params, state_fields, null);
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