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

        kitchen = new KitchenStub("name_to_be_defined", 22000);
        table = new TableStub("name to be defined", 22000);
        bar = new BarStub("name to be defined", 22000);

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
