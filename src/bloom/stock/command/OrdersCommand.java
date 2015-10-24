package bloom.stock.command;

import bloom.stock.Server;
import bloom.stock.Stock;

public class OrdersCommand extends Command {
    private Stock stock;

    public OrdersCommand(Stock stock, Server server) {
        super(server);
        this.stock = stock;
    }

    @Override
    public void execute() {
        this.server.write("ORDERS " + this.stock.getTicker());
        this.result = this.getOutput();
    }
}
