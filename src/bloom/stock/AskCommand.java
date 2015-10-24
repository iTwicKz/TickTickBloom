package bloom.stock;

public class AskCommand extends StockCommand {
    public AskCommand(Stock stock, int prices, int shares, Server server) {
        super(stock, prices, shares, server);
        this.type = "ASK";
    }
}
