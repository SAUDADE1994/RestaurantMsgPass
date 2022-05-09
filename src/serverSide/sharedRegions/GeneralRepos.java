package serverSide.sharedRegions;


import genclass.GenericIO;
import genclass.TextFile;
import serverSide.entities.ChefStates;
import serverSide.entities.StudentStates;
import serverSide.entities.WaiterStates;
import serverSide.main.SimulPar;

import java.util.Objects;

/**
 *  General Repository.
 *
 *    It is responsible to keep the visible internal state of the problem and to provide means for it
 *    to be printed in the logging file.
 *    It is implemented as an implicit monitor.
 *    All public methods are executed in mutual exclusion.
 *    There are no internal synchronization points.
 */

public class GeneralRepos {

    /**
     *  Name of the logging file.
     */
    private final String logFileName;


    /**
     * State of the Chef
     */
    private int chefState;

    /**
     * State of the Student
     */
    private int [] studentState;

    /**
     *   Id of the student sat at that chair in the array position
     */
    private int [] studentIds;

    /**
     * State of the Waiter
     */
    private int waiterState;


    /**
     *  Internal variable to count the seating
     */
    private int ids;

    /**
     * Number of courses: 0 upto M
     */
    private int nCourse;

    /**
     * Number of portions: 0 upto N
     */
    private int nPortion;


    /**
     * Singleton Instance
     */
    private static GeneralRepos instance;

    /**
     * @return Get singleton instance of this class
     *
     */
    public static GeneralRepos getInstance(String logFileName) {
        if (instance == null) {
            instance = new GeneralRepos(logFileName);
        }
        return instance;
    }

    /**
     * Private initialization of the instance General Repository
     *
     * @param logFileName name of the log file
     */
    private GeneralRepos(String logFileName) {

        if (logFileName == null || Objects.equals(logFileName, ""))
            this.logFileName = "logger";
        else this.logFileName = logFileName;

        chefState = ChefStates.WAITING_FOR_AN_ORDER;
        waiterState = WaiterStates.APPRAISING_SITUATION;
        studentState = new int[SimulPar.TOTAL_STUDENTS];
        studentIds = new int[SimulPar.TOTAL_STUDENTS];
        for(int i = 0; i < SimulPar.TOTAL_STUDENTS; i++) {
            studentState[i] = StudentStates.GOING_TO_THE_RESTAURANT;
            studentIds[i] = -1;
        }


        this.nCourse = 0;
        this.nPortion = 0;
        this.ids = 0;

        reportInitialStatus();
    }

    /**
     * Reports the initial status when creating te General Repository
     *
     */
    private void reportInitialStatus() {
        TextFile log = new TextFile();
        if (!log.openForWriting (".", logFileName))
        { GenericIO.writelnString ("The operation of creating the file " + logFileName + " failed!");
            System.exit (1);
        }

        log.writelnString ("                                          The Restaurant - Description of the internal state ");
        log.writelnString (" CHEF   WAITER   STU0  STU1   STU2   STU3   STU4   STU5   STU6  NCourse  NPortion             Table");
        if (!log.close ())
        { GenericIO.writelnString ("The operation of closing the file " + logFileName + " failed!");
            System.exit (1);
        }
        reportStatus ();
    }


    /**
     * Reports the status that changes during runtime
     *
     */
    private void reportStatus() {
        TextFile log = new TextFile ();                      // instantiation of a text file handler

        String lineStatus = "";                              // state line to be printed

        if (!log.openForAppending (".", logFileName))
        { GenericIO.writelnString ("The operation of opening for appending the file " + logFileName + " failed!");
            System.exit (1);
        }

        switch (chefState){
            case ChefStates.WAITING_FOR_AN_ORDER: lineStatus += " WAFOR ";
                break;
            case ChefStates.PREPARING_THE_COURSE: lineStatus += " PRPCS ";
                break;
            case ChefStates.DISHING_THE_PORTIONS: lineStatus += " DSHPT ";
                break;
            case ChefStates.DELIVERING_THE_PORTIONS: lineStatus += " DLVPT ";
                break;
            case ChefStates.CLOSING_SERVICE: lineStatus += " CLSSV ";
                break;
        }

        switch (waiterState){
            case WaiterStates.APPRAISING_SITUATION: lineStatus += " APPST ";
                break;
            case WaiterStates.PRESENTING_THE_MENU: lineStatus += " PRSMN ";
                break;
            case WaiterStates.TAKING_THE_ORDER: lineStatus += " TKODR ";
                break;
            case WaiterStates.PLACING_THE_ORDER: lineStatus += " PCODR ";
                break;
            case WaiterStates.WAITING_FOR_PORTION: lineStatus += " WTFPT ";
                break;
            case WaiterStates.PROCESSING_THE_BILL: lineStatus += " PRCBL ";
                break;
            case WaiterStates.RECEIVING_PAYMENT: lineStatus += " RECPM ";
        }

        for (int i = 0; i < SimulPar.TOTAL_STUDENTS; i++)
            switch (studentState[i])
            { case StudentStates.GOING_TO_THE_RESTAURANT:  lineStatus += " GGTRT ";
                break;
                case StudentStates.TAKING_A_SEAT_AT_THE_TABLE: lineStatus += " TKSTT ";
                    break;
                case StudentStates.SELECTING_THE_COURSES:      lineStatus += " SELCS ";
                    break;
                case StudentStates.ORGANIZING_THE_ORDER:    lineStatus += " OGODR ";
                    break;
                case StudentStates.CHATTING_WITH_COMPANIONS: lineStatus += " CHTWC ";
                    break;
                case StudentStates.ENJOYING_THE_MEAL: lineStatus += " EJYML ";
                    break;
                case StudentStates.PAYING_THE_BILL: lineStatus += " PYTBL ";
                    break;
                case StudentStates.GOING_HOME: lineStatus += " GGHOM ";
            }

        lineStatus += "  " + String.format(" %2d  ", nCourse) + String.format("     %2d      ", nPortion);
        for(int i = 0; i < SimulPar.TOTAL_STUDENTS; i++) {
            lineStatus += String.format(" %2d ", studentIds[i]);
        }
        log.writelnString((lineStatus));
        if (!log.close ())
        { GenericIO.writelnString ("The operation of closing the file " + logFileName + " failed!");
            System.exit (1);
        }
    }

    /**
     * Set Chef State and reports it
     *
     * @param state chef state
     */
    public synchronized void setChefState(int state) {
        chefState = state;
        reportStatus();
    }

    /**
     * Set Waiter State and reports it
     *
     * @param state waiter state
     */
    public synchronized void setWaiterState(int state) {
        waiterState = state;
        reportStatus();
    }

    /**
     * Set Student state
     *
     * @param id id of the student
     * @param state state of the student
     */
    public synchronized void setStudentState(int id, int state) {
        studentState[id] = state;
        reportStatus();
    }

    /**
     * Set the id of the student sitting in the chair
     *
     * @param id
     */
    public synchronized  void setStudentIds(int id) {
        studentIds[ids++] = id;
    }

    /**
     * Set the number of the Course
     *
     * @param nCourse
     */
    public synchronized void setnCourse(int nCourse) {
        this.nCourse = nCourse;
    }

    /**
     * Set the number of portion delivered
     *
     * @param nPortion
     */
    public synchronized void setnPortion(int nPortion) {
        this.nPortion = nPortion;
    }
}
