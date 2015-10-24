package bloom.main;

import bloom.stock.*;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Server server = new Server("codebb.cloudapp.net", "17429", "TickTickBloom", "YouKnowWhoTheNumba1teamB.CodeBthatis");
        Stock GOOG = new Stock("GOOG");
        ArrayList<Command> commands = new ArrayList<>();
        try {
            commands.add(new MyCashCommand(server));

            for (Command command : commands) {
                command.execute();
                System.out.println(command.getResult());
            }
        } finally {
            server.close();
        }
    }
}
