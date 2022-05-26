package clientSide.main;

import clientSide.entities.Student;
import clientSide.stubs.TableStub;

public class StudentMain {

    public static void main(String[] args) {

        Student[] students = new Student[SimulPar.TOTAL_STUDENTS];


        TableStub table;

        table = new TableStub(SimulPar.TABLE_NODE_NAME, SimulPar.TABLE_PORT);

        for(int i = 0; i < SimulPar.TOTAL_STUDENTS; i++) {
            students[i] = new Student(i, table);
        }

        /* start threads */
        for (int i = 0; i < SimulPar.TOTAL_STUDENTS; i++)
            students[i].start ();


        /* wait for the end */
        for (int i = 0; i < SimulPar.TOTAL_STUDENTS; i++)
        { try
        { students[i].join ();
        }
        catch (InterruptedException e) {}
            System.out.println("The Passenger "+(i+1)+" just terminated");
        }

        System.out.println("End of the Simulation");


    }
}
