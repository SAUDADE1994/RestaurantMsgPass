package serverSide.stubs;

import commInfra.CommunicationChannel;
import commInfra.Message;
import serverSide.main.FunctionsIds;

public class GeneralReposStub {

    /**
     *  Name of the computational system where the server is located.
     */

    private String serverHostName;

    /**
     *  Number of the listening port at the computational system where the server is located.
     */

    private int serverPortNumb;

    /**
     *  Instantiation of a remote reference
     *
     *    @param hostName name of the computational system where the server is located
     *    @param port number of the listening port at the computational system where the server is located
     */

    public GeneralReposStub (String hostName, int port)
    {
        serverHostName = hostName;
        serverPortNumb = port;
    }

    /**
     * Set Chef State and reports it
     *
     * @param state chef state
     */
    public void setChefState(int state) {
        CommunicationChannel com = new CommunicationChannel (serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[2];
        params[0] = state;

        Message m_toServer = new Message(38, params, 1, state_fields, 0, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        com.close ();
    }

    /**
     * Set Waiter State and reports it
     *
     * @param state waiter state
     */
    public void setWaiterState(int state) {
        CommunicationChannel com = new CommunicationChannel (serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[1];
        params[0] = state;

        Message m_toServer = new Message(39, params, 1, state_fields, 0, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        com.close ();
    }

    /**
     * Set Student state
     *
     * @param id id of the student
     * @param state state of the student
     */
    public void setStudentState(int id, int state) {
        CommunicationChannel com = new CommunicationChannel (serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[2];
        params[0] = id;
        params[1] = state;

        Message m_toServer = new Message(40, params, 1, state_fields, 0, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        com.close ();
    }

    /**
     * Set the id of the student sitting in the chair
     *
     * @param id
     */
    public  void setStudentIds(int id) {

        CommunicationChannel com = new CommunicationChannel (serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[2];
        params[0] = id;

        Message m_toServer = new Message(41, params, 1, state_fields, 0, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        com.close ();
    }

    /**
     * Set the number of portion delivered
     *
     * @param nPortion
     */
    public void setnPortion(int nPortion) {

        CommunicationChannel com = new CommunicationChannel (serverHostName, serverPortNumb);
        Object[] params = new Object[1];
        Object[] state_fields = new Object[1];
        state_fields[0] = nPortion;
        params[0] = nPortion;

        Message m_toServer = new Message(43, params, 1, state_fields, 0, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        com.close ();
    }

    /**
     *   Send shutdown message to the GeneraRepos server
     *
     */

    public void shutdown() {
        CommunicationChannel com = new CommunicationChannel (serverHostName, serverPortNumb);
        Object[] params = new Object[2];
        Object[] state_fields = new Object[2];

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



    public void setNextCourse() {

        CommunicationChannel com = new CommunicationChannel (serverHostName, serverPortNumb);
        Object[] params = new Object[2];
        Object[] state_fields = new Object[2];

        Message m_toServer = new Message(FunctionsIds.SETNCOURSE, params, 1, state_fields, 0, null);
        Message m_fromServer;

        while (!com.open ())
        { try
        { Thread.currentThread ().sleep ((long) (10));
        }
        catch (InterruptedException e) {}
        }

        com.writeObject (m_toServer);

        m_fromServer = (Message) com.readObject();

        com.close ();
    }
}
