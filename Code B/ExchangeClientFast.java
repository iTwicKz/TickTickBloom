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
import java.util.concurrent.TimeUnit;

/**
 *
 * @author atamarkin2
 */
public class ExchangeClientFast {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, InterruptedException {

            if (args.length < 5) {
                System.out.println("Usage: \nclientTask <host> <port> <user> <password> <command...>");

            }
            Socket socket = new Socket("codebb.cloudapp.net", 17429);
            PrintWriter pout = new PrintWriter(socket.getOutputStream());
            BufferedReader bin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pout.println("TickTickBloom" + " " + "YouKnowWhoTheNumba1teamB.CodeBthatis");

            String[] stocks = {"AAPL", "ATVI", "EA", "FB", "GOOG", "MSFT", "SBUX", "SNY", "TSLA", "TWTR"};
            int[] prevPrices = new int[10];
            for(int j = 0; j < 1000; j++){
                for(int z = 0; z < stocks.length; z++){
                  pout.println("SECURITIES");
                  pout.flush();
                  int netWorth = 0;
                  String secureLine = bin.readLine();
                  for(int q = 0; q < secureLine.length() - stocks[z].length(); q++){
                    //System.out.println(q);
                    if((secureLine.substring(q, q+(stocks[z].length()))).equals(stocks[z])){
                      System.out.println("YOU MADE IT!!");
                      String priceStr = secureLine.substring(q+(stocks[z].length())+1, q+(stocks[z].length())+7);
                      netWorth = Integer.parseInt(priceStr);
                      break;
                    }
                  }
                  System.out.println("NET WORTH: " + netWorth + "++++++++++++++++++++");
                  if(prevPrices[z] > netWorth){
                    System.out.println("BAD STOCK");
                    prevPrices[z] = netWorth;
                    continue;
                  }
                  prevPrices[z] = netWorth;
                  pout.println("ORDERS " + stocks[z]);
                  pout.flush();
                  String line = bin.readLine();
                  System.out.println(line);
                  if((line.substring(0, 5)).equals("ERROR")) {
                    System.out.println("BBBBREREEEEEAAAAK!!!!!!!!!");
                    continue;
                  }
                  int prevWhiteSpaceChar = line.length() - 1;
                  int whiteSpaceCount = -1;
                  String askingPrice = "";
                  String biddingPrice = "";

                  for(int i = line.length() - 1 ; i > 0; i--){
                    if(line.charAt(i) == ' '){
                      whiteSpaceCount++;
                      if(whiteSpaceCount == 2){
                        biddingPrice = line.substring(i, prevWhiteSpaceChar);
                        //biddingPrice = Integer.parseInt(temp);
                        System.out.println(biddingPrice);
                      }
                      else if(whiteSpaceCount == 6){
                        askingPrice = line.substring(i, prevWhiteSpaceChar);
                        //askingPrice = Integer.parseInt(tempAsk);
                        System.out.println(askingPrice);
                      }
                      else{
                        prevWhiteSpaceChar = i;
                      }
                    }
                  }

                  pout.println("BID " + stocks[z] + " " + biddingPrice + " 1");

                  System.out.println(line);
                  System.out.println("Bought " + stocks[z] + " for " + biddingPrice);
                  pout.flush();

                  //line = bin.readLine();
                  //System.out.println(line);

                  Thread.sleep(1000);

                  pout.println("ASK " + stocks[z] + " " + askingPrice + " 1");
                  System.out.println("Sold " + stocks[z] + " for " + askingPrice);
                  pout.flush();
                  //line = bin.readLine();
                  //System.out.println(line);
                  Thread.sleep(1000);


                }

                // Scanner input = new Scanner(System.in);
                // String inLine = input.nextLine();
                // if(inLine.equals("QUIT")) break;
                // if(inLine.equals("ORDERS")) printOrders();
                // pout.println(inLine);
                //
                // pout.flush();
                // String line;
                // line = bin.readLine();
                // //while ((line = bin.readLine()) != "") {
                // System.out.println(line);

            }
            pout.println("CLEAR_BID");
            pout.println("CLEAR_ASK");
            pout.println("CLOSE_CONNECTION");
            bin.close();
            pout.close();
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



      }


}
