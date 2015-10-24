package bloom.main;

import bloom.stock.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Server server = new Server("codebb.cloudapp.net", "17429", "TickTickBloom", "YouKnowWhoTheNumba1teamB.CodeBthatis");
        Stock GOOG = new Stock("GOOG");
        try {
            BidCommand bidCommand = new BidCommand(GOOG, 5, 1, server);
            bidCommand.execute();
            AskCommand askCommand = new AskCommand(GOOG, 5, 1, server);
            askCommand.execute();
            System.out.println(bidCommand.getOutput());
            System.out.println(askCommand.getOutput());
        } finally {
            server.close();
        }
    }
}
