package serverSide.sharedRegions;

import commInfra.Message;

public class TableInterface implements SharedRegionInterface {

    private Table table;

    private boolean shutdown;

    public TableInterface(Table table) {
        this.table = table;
        this.shutdown = hasShutdown();
    }

    @Override
    public Message processAndReply(Message message) {

        return message;
    }

    @Override
    public boolean hasShutdown() {
        return shutdown;
    }
}
