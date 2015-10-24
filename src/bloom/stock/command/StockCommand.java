package bloom.stock.command;

import bloom.stock.Server;
import bloom.stock.Stock;

public abstract class StockCommand extends Command {
    private Stock stock;
    private int prices;
    private int shares;

    protected String type;


    public StockCommand(Stock stock, int prices, int shares, Server server) {
        super(server);
        this.stock = stock;
        this.prices = prices;
        this.shares = shares;
    }

    @Override
    public void execute() {
        this.server.write(this.type + " " + this.stock.getTicker() + " " + this.prices + " " + this.shares);
        this.result = this.getOutput();
    }
}
