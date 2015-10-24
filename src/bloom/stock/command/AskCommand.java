package bloom.stock.command;

import bloom.stock.Server;
import bloom.stock.Stock;

public class AskCommand extends StockCommand {
    public AskCommand(Stock stock, int prices, int shares, Server server) {
        super(stock, prices, shares, server);
        this.type = "ASK";
    }
}
