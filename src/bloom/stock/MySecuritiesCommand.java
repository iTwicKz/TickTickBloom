package bloom.stock;

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
