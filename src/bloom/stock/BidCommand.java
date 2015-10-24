package bloom.stock;

public class BidCommand extends StockCommand {
    public BidCommand(Stock stock, int prices, int shares, Server server) {
        super(stock, prices, shares, server);
        this.type = "BID";
    }
}
