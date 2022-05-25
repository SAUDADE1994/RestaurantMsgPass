package clientSide.main;

import clientSide.entities.Waiter;
import clientSide.stubs.BarStub;
import clientSide.stubs.KitchenStub;
import clientSide.stubs.TableStub;

public class WaiterMain {

    public static void main(String[] args) {

        Waiter waiter;

        KitchenStub kitchen;
        TableStub table;
        BarStub bar;

        kitchen = new KitchenStub(SimulPar.KITCHEN_HOSTNAME, SimulPar.KITCHEN_PORT);
        table = new TableStub(SimulPar.TABLE_NODE_NAME, SimulPar.TABLE_PORT);
        bar = new BarStub(SimulPar.BAR_HOSTNAME, SimulPar.BAR_PORT);

        waiter = new Waiter(0, bar, kitchen, table);


        /* start thread */
        waiter.start ();

        /* wait for the end */
        try
        { waiter.join ();
        }
        catch (InterruptedException e) {}
        System.out.println("The Chef 1 just terminated");

        System.out.println("End of the Simulation");

    }
}
