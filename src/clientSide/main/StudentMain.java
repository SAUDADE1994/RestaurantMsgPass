package clientSide.main;

import clientSide.entities.Student;
import clientSide.stubs.BarStub;
import clientSide.stubs.TableStub;

public class StudentMain {

    public static void main(String[] args) {

        Student[] students = new Student[SimulPar.TOTAL_STUDENTS];


        TableStub table;

        table = new TableStub("sd209@l04010-ws01.ua.pt", 22380);

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
