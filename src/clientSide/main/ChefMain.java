package clientSide.main;

import clientSide.entities.Chef;
import clientSide.stubs.KitchenStub;
import clientSide.stubs.TableStub;

public class ChefMain {

    public static void main(String[] args) {
        Chef chef;

        KitchenStub kitchen;
        TableStub table;
        kitchen = new KitchenStub(SimulPar.KITCHEN_HOSTNAME, SimulPar.KITCHEN_PORT);
        table = new TableStub(SimulPar.TABLE_NODE_NAME, SimulPar.TABLE_PORT);

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
