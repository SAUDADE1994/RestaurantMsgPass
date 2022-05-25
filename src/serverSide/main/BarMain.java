package serverSide.main;

import commInfra.ServerCom;
import genclass.GenericIO;
import serverSide.entities.ServiceProviderAgent;
import serverSide.sharedRegions.Bar;
import serverSide.sharedRegions.BarInterface;
import serverSide.sharedRegions.SharedRegionInterface;
import serverSide.stubs.GeneralReposStub;

import java.net.SocketTimeoutException;


/**
 *    Server side of the Bar Shared Region.
 *
 *    Request serialization variant.
 *    It waits for the start of the message exchange.
 */
public class BarMain {


    /**
     *    Main method.
     *
     *    @param args runtime arguments
     */
    public static void main (String[] args)
    {
        /* service is established */

        ServerCom serverCom, sconi;                                        // communication channels
        int portNumb = SimulPar.bar_port;                                          // port nunber for listening to service requests

        serverCom = new ServerCom (portNumb);
        serverCom.start ();                             // service is instantiated
        serverCom.setSoTimeout(10000);
        GenericIO.writelnString ("Service is established!");
        GenericIO.writelnString ("Server is listening for service requests.");

        GeneralReposStub generalReposStub = new GeneralReposStub(SimulPar.generalrepos_ssh, SimulPar.generalrepos_port);
        Bar bar = new Bar(generalReposStub);
        SharedRegionInterface sharedRegionInterface = new BarInterface(bar);

        /* service request processing */
        // service provider agent
        while (!sharedRegionInterface.hasShutdown())
        {
            try {
                sconi = serverCom.accept ();                                     // enter listening procedure
                ServiceProviderAgent serviceProviderAgent = new ServiceProviderAgent (sconi, sharedRegionInterface);            // start a service provider agent to address
                serviceProviderAgent.start ();
            }
            catch(SocketTimeoutException ste) {}
        }

        GenericIO.writelnString ("Service is closed!");
    }
}
