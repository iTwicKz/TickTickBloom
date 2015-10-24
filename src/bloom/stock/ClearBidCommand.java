package bloom.stock;

public class ClearBidCommand extends Command {
    private Stock stock;

    public ClearBidCommand(Stock stock, Server server) {
        super(server);
    }

    @Override
    public void execute() {
        this.server.write("CLEAR_BID " + stock.getName());
        this.result = this.getResult();
    }
}
