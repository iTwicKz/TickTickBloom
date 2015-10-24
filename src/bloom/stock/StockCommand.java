package bloom.stock;

import java.io.IOException;
import java.util.ArrayList;

public abstract class StockCommand implements Command {
    private Stock stock;
    private int prices;
    private int shares;
    private Server server;

    protected String type;

    public StockCommand(Stock stock, int prices, int shares, Server server) {
        this.stock = stock;
        this.prices = prices;
        this.shares = shares;
        this.server = server;
    }

    @Override
    public void execute() {
        this.server.write(this.type + " " + this.stock.getName() + " " + this.prices + " " + this.shares);
    }

    @Override
    public ArrayList<String> getOutput() {
        try {
            return this.server.getOutput();
        } catch (IOException e) {
            ArrayList<String> error = new ArrayList<String>();
            error.add("error");
            return error;
        }
    }
}
