/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author atamarkin2
 */
public class ExchangeClient {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

            if (args.length < 5) {
                System.out.println("Usage: \nclientTask <host> <port> <user> <password> <command...>");

            }
            Socket socket = new Socket("codebb.cloudapp.net", 17429);
            PrintWriter pout = new PrintWriter(socket.getOutputStream());
            BufferedReader bin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pout.println("TickTickBloom" + " " + "YouKnowWhoTheNumba1teamB.CodeBthatis");


            while(true){
                Scanner input = new Scanner(System.in);
                String inLine = input.next();
                if(inLine.equals("QUIT")) break;
                pout.println(inLine);


                pout.flush();
                String line;
                while ((line = bin.readLine()) != null) {
                    System.out.println(line);
                    System.out.println("NSFKSKFN");

                }


            }
            // for (int i = 4; i < args.length; i++) {
            //     pout.println(args[i]);
            //
            //     //STOCKS
            //
            //     System.out.println();
            //     pout.println("ORDERS AAPL");
            //     pout.println("ORDERS ATVI");
            //     pout.println("ORDERS EA");
            //     pout.println("ORDERS FB");
            //     pout.println("ORDERS GOOG");
            //     pout.println("ORDERS MSFT");
            //     pout.println("ORDERS SBUX");
            //     pout.println("ORDERS SNY");
            //     pout.println("ORDERS TSLA");
            //     pout.println("ORDERS TWTR");
            //     System.out.println();
            //
            //     pout.println("MY_ORDERS");
            //     pout.println("MY_SECURITIES");
            //     pout.println("CLOSE_CONNECTION");
            //     pout.flush();
                // String line;
                // while ((line = bin.readLine()) != null) {
                //     System.out.println(line);
                // }
                // pout.close();
                // bin.close();

pout.println("CLOSE_CONNECTION");
                bin.close();
                pout.close();

      }
}
