package bloom.stock;

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
