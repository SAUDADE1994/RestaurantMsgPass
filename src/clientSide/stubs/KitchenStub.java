package clientSide.stubs;

import clientSide.entities.Chef;
import clientSide.entities.Waiter;
import commInfra.CommunicationChannel;
import commInfra.Message;
import serverSide.main.FunctionsIds;

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
        Object[] state_fields = new Object[]{
                chef.getChefId(), chef.getChefState()
        };
        Object[] params = new Object[0];

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.WATCH_THE_NEWS, params, state_fields, null);
        chefCallFunctionMsg(chef, com, m_toServer);

    }

    private boolean chefCallFunctionMsg(Chef chef, CommunicationChannel com, Message m_toServer) {
        Message m_fromServer;

        while (!com.open ()) {
            try {
                Thread.currentThread().sleep (10L);
            } catch (InterruptedException ignored) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        chef.setChefState((Integer) m_fromServer.getStateFields()[1]);
        boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();

        return result;
    }

    @Override
    public void startPreparing() {
        Chef chef = (Chef) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] state_fields = new Object[]{
                chef.getChefId(), chef.getChefState()
        };
        Object[] params = new Object[0];

        /* operation number to be defined */
        Message m_toServer = new Message(4, params, state_fields, null);
        chefCallFunctionMsg(chef, com, m_toServer);
    }

    @Override
    public void alertTheWaiter() {
        Chef chef = (Chef) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] state_fields = new Object[]{
                chef.getChefId(), chef.getChefState()
        };
        Object[] params = new Object[0];

        /* operation number to be defined */
        Message m_toServer = new Message(5, params, state_fields, null);

        chefCallFunctionMsg(chef, com, m_toServer);

    }

    @Override
    public void proceedToPresentation() {
        Chef chef = (Chef) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] state_fields = new Object[]{
                chef.getChefId(), chef.getChefState()
        };
        Object[] params = new Object[0];

        /* operation number to be defined */
        Message m_toServer = new Message(6, params, state_fields, null);
        chefCallFunctionMsg(chef, com, m_toServer);

    }

    @Override
    public void haveNextPortionReady() {
        Chef chef = (Chef) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] state_fields = new Object[]{
                chef.getChefId(), chef.getChefState()
        };
        Object[] params = new Object[0];

        /* operation number to be defined */
        Message m_toServer = new Message(7, params, state_fields, null);
        chefCallFunctionMsg(chef, com, m_toServer);

    }

    @Override
    public void continuePreparation() {
        Chef chef = (Chef) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] state_fields = new Object[]{
                chef.getChefId(), chef.getChefState()
        };
        Object[] params = new Object[0];

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.CONTINUE_PREPARATION, params, state_fields, null);

        chefCallFunctionMsg(chef, com, m_toServer);
    }

    @Override
    public boolean haveAllPortionsBeenDelivered() {
        Chef chef = (Chef) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] state_fields = new Object[]{
                chef.getChefId(), chef.getChefState()
        };
        Object[] params = new Object[0];

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.HAVE_ALL_PORTIONS_BEEN_DELIVERED, params, state_fields, null);

        return chefCallFunctionMsg(chef, com, m_toServer);
    }

    @Override
    public boolean hasTheOrderBeenCompleted() {

        Chef chef = (Chef) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] state_fields = new Object[]{
                chef.getChefId(), chef.getChefState()
        };
        Object[] params = new Object[0];

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.HAS_THE_ORDER_BEEN_COMPLETED, params, state_fields, null);

        return chefCallFunctionMsg(chef, com, m_toServer);
    }

    @Override
    public void cleanUp() {
        Chef chef = (Chef) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] state_fields = new Object[]{
                chef.getChefId(), chef.getChefState()
        };
        Object[] params = new Object[0];

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.CLEAN_UP, params, state_fields, null);

        chefCallFunctionMsg(chef, com, m_toServer);

    }

    @Override
    public void handTheNoteToTheChef() {
        Waiter waiter = (Waiter) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] state_fields = new Object[] {
                waiter.getWaiterId(), waiter.getWaiterState()
        };
        Object[] params = new Object[0];

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.HAND_THE_NOTE_TO_THE_CHEF, params, state_fields, null);

        waiterCallFunctionMsg(waiter, com, m_toServer);

    }

    @Override
    public boolean haveAllPortionsBeenCollected() {

        Waiter waiter = (Waiter) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] state_fields = new Object[] {
                waiter.getWaiterId(), waiter.getWaiterState()
        };
        Object[] params = new Object[0];

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.HAVE_ALL_PORTIONS_BEEN_COLLECTED, params, state_fields, null);
        return waiterCallFunctionMsg(waiter, com, m_toServer);
    }

    private boolean waiterCallFunctionMsg(Waiter waiter, CommunicationChannel com, Message m_toServer) {
        Message m_fromServer;

        while (!com.open ()) {
            try {
                Thread.currentThread().sleep (10L);
            } catch (InterruptedException ignored) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        waiter.setWaiterState((Integer) m_fromServer.getStateFields()[1]);
        boolean result = (Boolean) m_fromServer.getReturnValue();

        com.close ();
        return result;
    }

    @Override
    public void collectPortion() {
        Waiter waiter = (Waiter) Thread.currentThread();
        CommunicationChannel com = new CommunicationChannel(serverHostName, serverPortNumb);
        Object[] state_fields = new Object[] {
                waiter.getWaiterId(), waiter.getWaiterState()
        };
        Object[] params = new Object[0];

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.COLLECT_PORTION, params, state_fields, null);
        Message m_fromServer;

        while (!com.open ()) {
            try {
                Thread.currentThread ().sleep (10L);
            } catch (InterruptedException ignored) {}
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
        Object[] state_fields = new Object[] {
                waiter.getWaiterId(), waiter.getWaiterState()
        };
        Object[] params = new Object[0];

        /* operation number to be defined */
        Message m_toServer = new Message(FunctionsIds.LOOK_AROUND_KITCHEN, params, state_fields, null);

        waiterCallFunctionMsg(waiter, com, m_toServer);
    }

    /**
     *
     *Method called to shutdown the Kitchen server
     *
     */

    public void shutdown() {
        CommunicationChannel com = new CommunicationChannel (serverHostName, serverPortNumb);
        Object[] state_fields = new Object[0];
        Object[] params = new Object[0];

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