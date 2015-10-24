package bloom.stock;

public class OrdersCommand extends Command {
    private Stock stock;

    public OrdersCommand(Stock stock, Server server) {
        super(server);
        this.stock = stock;
    }

    @Override
    public void execute() {
        this.server.write("ORDERS " + this.stock.getName());
        this.result = this.getOutput();
    }
}
