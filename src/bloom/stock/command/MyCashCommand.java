package bloom.stock.command;

import bloom.stock.Server;

public class MyCashCommand extends Command {
    public MyCashCommand(Server server) {
        super(server);
    }

    @Override
    public void execute() {
        this.server.write("MY_CASH");
        this.result = this.getOutput();
    }
}
