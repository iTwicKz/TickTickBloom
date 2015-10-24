package bloom.stock;

public class SecuritiesCommand extends Command {
    public SecuritiesCommand(Server server) {
        super(server);
    }

    @Override
    public void execute() {
        this.server.write("SECURITIES");
        this.result = this.getOutput();
    }
}
