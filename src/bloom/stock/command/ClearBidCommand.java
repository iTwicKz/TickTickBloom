package bloom.stock.command;

import bloom.stock.Server;
import bloom.stock.Stock;

public class ClearBidCommand extends Command {
    private Stock stock;

    public ClearBidCommand(Stock stock, Server server) {
        super(server);
    }

    @Override
    public void execute() {
        this.server.write("CLEAR_BID " + stock.getTicker());
        this.result = this.getResult();
    }
}
