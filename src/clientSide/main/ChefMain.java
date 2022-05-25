package clientSide.main;

import clientSide.entities.Chef;
import clientSide.stubs.KitchenStub;
import clientSide.stubs.TableStub;

public class ChefMain {

    public static void main(String[] args) {
        Chef chef;

        KitchenStub kitchen;
        TableStub table;
        kitchen = new KitchenStub(SimulPar.kitchen_ssh, SimulPar.kitchen_port);
        table = new TableStub(SimulPar.table_ssh, SimulPar.table_port);

        chef = new Chef(0, kitchen, table);


        /* start thread */
        chef.start ();

        /* wait for the end */
        try
        { chef.join ();
        }
        catch (InterruptedException e) {}
        System.out.println("The Chef 1 just terminated");

        System.out.println("End of the Simulation");

    }
}
