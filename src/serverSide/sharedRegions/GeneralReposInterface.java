package serverSide.sharedRegions;

import commInfra.Message;

public class GeneralReposInterface implements SharedRegionInterface {

    private GeneralRepos rp;

    private boolean shutdown;


    public GeneralReposInterface(GeneralRepos rp) {
        this.rp = rp;
        this.shutdown = false;
    }

    @Override
    public Message processAndReply(Message message) {

        Object res = null;
        Object[] state;



        return null;
    }

    @Override
    public boolean hasShutdown() {
        return false;
    }
}
