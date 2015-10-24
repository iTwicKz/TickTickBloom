package bloom.main;

import bloom.stock.*;
import bloom.stock.command.*;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Server info_server = new Server("codebb.cloudapp.net", "17429", "TickTickBloom", "YouKnowWhoTheNumba1teamB.CodeBthatis");
        Server write_server = new Server("codebb.cloudapp.net", "17429", "TickTickBloom", "YouKnowWhoTheNumba1teamB.CodeBthatis");
        Stock GOOG = new Stock("GOOG");
        ArrayList<Command> commands = new ArrayList<>();
        try {
            commands.add(new MyCashCommand(info_server));
            commands.add(new MyOrdersCommand(info_server));
            commands.add(new MySecuritiesCommand(info_server));
            commands.add(new SecuritiesCommand(info_server));

            commands.add(new OrdersCommand(GOOG, info_server));

            SecuritiesCommand securities = new SecuritiesCommand(info_server);
            securities.execute();
            StockMap stocks = new StockMap(securities.getResult());

            for (Command command : commands) {
                command.execute();
                System.out.println(command.getResult());
            }

            System.out.println(stocks);

        } finally {
            info_server.close();
            write_server.close();
        }
    }
}
