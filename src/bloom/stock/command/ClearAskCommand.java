package bloom.stock.command;

import bloom.stock.Server;
import bloom.stock.Stock;

public class ClearAskCommand extends Command {
    private Stock stock;

    public ClearAskCommand(Stock stock, Server server) {
        super(server);
        this.stock = stock;
    }

    @Override
    public void execute() {
        this.server.write("CLEAR_ASK " + stock.getName());
        this.result = this.getResult();
    }
}
