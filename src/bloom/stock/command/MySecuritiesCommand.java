package bloom.stock.command;

import bloom.stock.Server;

public class MySecuritiesCommand extends Command {
    public MySecuritiesCommand(Server server) {
        super(server);
    }

    @Override
    public void execute() {
        this.server.write("MY_SECURITIES");
        this.result = this.getOutput();
    }
}
