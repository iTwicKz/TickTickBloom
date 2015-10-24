package bloom.stock.command;

import bloom.stock.Server;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Command {
    protected Server server;
    protected ArrayList<String> result;

    public Command(Server server) {
        this.server = server;
    }

    public abstract void execute();

    public ArrayList<String> getOutput() {
        try {
            return this.server.getOutput();
        } catch (IOException e) {
            ArrayList<String> error = new ArrayList<String>();
            error.add("ERROR");
            return error;
        }
    }

    public ArrayList<String> getResult() {
        return this.result;
    }
}
