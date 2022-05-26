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
        Object[] state_fields = new Object[2];
        Object[] params = new Object[] {state};

        Message m_toServer = new Message(FunctionsIds.SET_CHEF_STATE, params, state_fields, null);

        while (!com.open ()) {
            try {
                Thread.currentThread ().sleep (10L);
            } catch (InterruptedException ignored) {}
        }

        com.writeObject (m_toServer);

        com.close ();
    }

    /**
     * Set Waiter State and reports it
     *
     * @param state waiter state
     */
    public void setWaiterState(int state) {
        CommunicationChannel com = new CommunicationChannel (serverHostName, serverPortNumb);
        Object[] state_fields = new Object[2];
        Object[] params = new Object[] {state};

        Message m_toServer = new Message(FunctionsIds.SET_WAITER_STATE, params, state_fields, null);

        while (!com.open ()) {
            try {
                Thread.currentThread ().sleep (10L);
            } catch (InterruptedException ignored) {}
        }

        com.writeObject (m_toServer);

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
        Object[] state_fields = new Object[2];
        Object[] params = new Object[] {id, state};

        Message m_toServer = new Message(FunctionsIds.SET_STUDENT_STATE, params, state_fields, null);

        while (!com.open ()) {
            try {
                Thread.currentThread ().sleep (10L);
            } catch (InterruptedException ignored) {}
        }

        com.writeObject (m_toServer);

        com.close ();
    }

    /**
     * Set the id of the student sitting in the chair
     *
     * @param id student id
     */
    public  void setStudentIds(int id) {

        CommunicationChannel com = new CommunicationChannel (serverHostName, serverPortNumb);
        Object[] params = new Object[] {id};
        Object[] state_fields = new Object[2];

        Message m_toServer = new Message(FunctionsIds.SET_STUDENT_IDS, params, state_fields, null);

        while (!com.open ()) {
            try {
                Thread.currentThread ().sleep (10L);
            } catch (InterruptedException ignored) {}
        }

        com.writeObject (m_toServer);

        com.close ();
    }

    /**
     * Set the number of the Course
     *
     * @param nCourse
     */
    public void setnCourse(int nCourse) {

        CommunicationChannel com = new CommunicationChannel (serverHostName, serverPortNumb);
        Object[] params = new Object[] {nCourse};
        Object[] state_fields = new Object[2];

        Message m_toServer = new Message(FunctionsIds.SET_N_COURSE, params, state_fields, null);

        while (!com.open ()) {
            try {
                Thread.currentThread ().sleep (10L);
            } catch (InterruptedException ignored) {}
        }

        com.writeObject (m_toServer);

        com.close ();
    }

    /**
     * Set new value for the number of portion delivered
     *
     * @param nPortion Number of portions delivered
     */
    public void setnPortion(int nPortion) {

        CommunicationChannel com = new CommunicationChannel (serverHostName, serverPortNumb);
        Object[] params = new Object[] {nPortion};
        Object[] state_fields = new Object[2];

        Message m_toServer = new Message(FunctionsIds.SET_N_PORTION, params, state_fields, null);

        while (!com.open ()) {
            try {
                Thread.currentThread ().sleep (10L);
            } catch (InterruptedException ignored) {}
        }

        com.writeObject (m_toServer);

        com.close ();
    }

    /**
     *   Send shutdown message to the GeneraRepos server
     *
     */

    public void shutdown() {
        CommunicationChannel com = new CommunicationChannel (serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[2];

        Message m_toServer = new Message(FunctionsIds.SHUTDOWN, params, state_fields, null);

        while (!com.open ()) {
            try {
                Thread.currentThread ().sleep (10L);
            } catch (InterruptedException ignored) {}
        }

        com.writeObject (m_toServer);

        com.close ();
    }


    public void setNextCourse() {

        CommunicationChannel com = new CommunicationChannel (serverHostName, serverPortNumb);
        Object[] params = new Object[0];
        Object[] state_fields = new Object[2];

        Message m_toServer = new Message(FunctionsIds.SET_N_COURSE, params, state_fields, null);

        while (!com.open ()) {
            try {
                Thread.currentThread ().sleep (10L);
            } catch (InterruptedException ignored) {}
        }

        com.writeObject (m_toServer);

        com.close ();
    }
}
