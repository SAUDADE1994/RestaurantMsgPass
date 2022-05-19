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

        kitchen = new KitchenStub("sd209@l04010-ws03.ua.pt", 22382);
        table = new TableStub("sd209@l04010-ws01.ua.pt", 22380);
        bar = new BarStub("sd209@l04010-ws02.ua.pt", 22381);

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
