package clientSide.stubs;

import clientSide.entities.Chef;
import clientSide.entities.Waiter;
import commInfra.CommunicationChannel;
import commInfra.Message;

public class KitchenStub implements IKitchen_Chef, IKitchen_Waiter {

    String serverHostName;

    int serverPortNumb;

    public KitchenStub(String serverName, int port) {
        serverHostName = serverName;
        serverPortNumb = port;
    }

    @Override
    public void watchTheNews() {

        Chef chef = (Chef) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[2];
        state_fields[0] = chef.getChefId();
        state_fields[1] = chef.getChefState();

        /* operation number to be defined */
        Message m_toServer = new Message(3, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        chef.setChefState((int) m_fromServer.getStateFields()[1]);
        //boolean result = (boolean) m_fromServer.getReturnValue();

        com.close ();

    }

    @Override
    public void startPreparing() {
        Chef chef = (Chef) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[2];
        state_fields[0] = chef.getChefId();
        state_fields[1] = chef.getChefState();

        /* operation number to be defined */
        Message m_toServer = new Message(4, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        chef.setChefState((int) m_fromServer.getStateFields()[1]);
        //boolean result = (boolean) m_fromServer.getReturnValue();

        com.close ();
    }

    @Override
    public void alertTheWaiter() {
        Chef chef = (Chef) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[2];
        state_fields[0] = chef.getChefId();
        state_fields[1] = chef.getChefState();

        /* operation number to be defined */
        Message m_toServer = new Message(5, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        chef.setChefState((int) m_fromServer.getStateFields()[1]);
        //boolean result = (boolean) m_fromServer.getReturnValue();

        com.close ();

    }

    @Override
    public void proceedToPresentation() {
        Chef chef = (Chef) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[2];
        state_fields[0] = chef.getChefId();
        state_fields[1] = chef.getChefState();

        /* operation number to be defined */
        Message m_toServer = new Message(6, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        chef.setChefState((int) m_fromServer.getStateFields()[1]);
        //boolean result = (boolean) m_fromServer.getReturnValue();

        com.close ();

    }

    @Override
    public void haveNextPortionReady() {
        Chef chef = (Chef) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[2];
        state_fields[0] = chef.getChefId();
        state_fields[1] = chef.getChefState();

        /* operation number to be defined */
        Message m_toServer = new Message(7, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        chef.setChefState((int) m_fromServer.getStateFields()[1]);
        //boolean result = (boolean) m_fromServer.getReturnValue();

        com.close ();

    }

    @Override
    public void continuePreparation() {
        Chef chef = (Chef) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[2];
        state_fields[0] = chef.getChefId();
        state_fields[1] = chef.getChefState();

        /* operation number to be defined */
        Message m_toServer = new Message(8, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        chef.setChefState((int) m_fromServer.getStateFields()[1]);
        //boolean result = (boolean) m_fromServer.getReturnValue();

        com.close ();
    }

    @Override
    public boolean haveAllPortionsBeenDelivered() {
        Chef chef = (Chef) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[2];
        state_fields[0] = chef.getChefId();
        state_fields[1] = chef.getChefState();

        /* operation number to be defined */
        Message m_toServer = new Message(9, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        chef.setChefState((int) m_fromServer.getStateFields()[1]);
        boolean result = (boolean) m_fromServer.getReturnValue();

        com.close ();

        return result;
    }

    @Override
    public boolean hasTheOrderBeenCompleted() {

        Chef chef = (Chef) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[2];
        state_fields[0] = chef.getChefId();
        state_fields[1] = chef.getChefState();

        /* operation number to be defined */
        Message m_toServer = new Message(10, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        chef.setChefState((int) m_fromServer.getStateFields()[1]);
        boolean result = (boolean) m_fromServer.getReturnValue();

        com.close ();
        return result;
    }

    @Override
    public void cleanUp() {
        Chef chef = (Chef) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[2];
        state_fields[0] = chef.getChefId();
        state_fields[1] = chef.getChefState();

        /* operation number to be defined */
        Message m_toServer = new Message(11, params, 0, state_fields, 2, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        chef.setChefState((int) m_fromServer.getStateFields()[1]);
        //boolean result = (boolean) m_fromServer.getReturnValue();

        com.close ();

    }

    @Override
    public void handTheNoteToTheChef() {
        Waiter waiter = (Waiter) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[2];
        state_fields[0] =waiter.getWaiterId();
        state_fields[1] = waiter.getWaiterState();

        /* operation number to be defined */
        Message m_toServer = new Message(12, params, 0, state_fields, 2, null);
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
    public boolean haveAllPortionsBeenCollected() {

        Waiter waiter = (Waiter) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[2];
        state_fields[0] =waiter.getWaiterId();
        state_fields[1] = waiter.getWaiterState();

        /* operation number to be defined */
        Message m_toServer = new Message(13, params, 0, state_fields, 2, null);
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
        boolean result = (boolean) m_fromServer.getReturnValue();

        com.close ();
        return result;
    }

    @Override
    public void collectPortion() {
        Waiter waiter = (Waiter) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[2];
        state_fields[0] =waiter.getWaiterId();
        state_fields[1] = waiter.getWaiterState();

        /* operation number to be defined */
        Message m_toServer = new Message(14, params, 0, state_fields, 2, null);
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
    public void lookAround() {
        Waiter waiter = (Waiter) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[2];
        state_fields[0] =waiter.getWaiterId();
        state_fields[1] = waiter.getWaiterState();

        /* operation number to be defined */
        Message m_toServer = new Message(15, params, 0, state_fields, 2, null);
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
     *Method called to shutdown the Kitchen server
     *
     */

    public void shutdown() {
        CommunicationChannel com = new CommunicationChannel (serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[1];

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