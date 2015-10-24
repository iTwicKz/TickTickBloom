package bloom.stock.command;

import bloom.stock.Server;

public class MyOrdersCommand extends Command {
    public MyOrdersCommand(Server server) {
        super(server);
    }

    @Override
    public void execute() {
        this.server.write("MY_ORDERS");
        this.result = this.getOutput();
    }
}
