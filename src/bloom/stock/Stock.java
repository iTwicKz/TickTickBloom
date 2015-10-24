package bloom.stock;

import java.util.ArrayList;

public class Stock {
    private String ticker;
    private double netWorth;
    private double dividendRatio;
    private double volatility;

    public Stock(String ticker) {
        this.ticker = ticker;
        this.netWorth = 0.0;
        this.dividendRatio = 0.0;
        this.volatility = 0.0;
    }

    /*
       SECURITIES_OUT <ticker> <net_worth> <dividend_ratio> <volatility>
     */
    public Stock(ArrayList<String> args) throws IllegalArgumentException {
        if (args.size() != 4) {
            throw new IllegalArgumentException("Args is wrong size, must be four");
        }

        this.ticker = args.get(0);
        this.setNetWorth(args.get(1));
        this.setDividendRatio(args.get(2));
        this.setVolatility(args.get(3));
    }

    public String toString() {
        return "Ticker: " + this.ticker + "\n" +
               "netWorth: " + this.netWorth + "\n" +
               "dividendRatio: " + this.dividendRatio + "\n" +
               "volatility: " + this.volatility + "\n";
    }

    public String getTicker() {
        return ticker;
    }

    public double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(String netWorth) {
        this.netWorth = Double.parseDouble(netWorth);
    }

    public void setNetWorth(double netWorth) {
        this.netWorth = netWorth;
    }

    public double getDividendRatio() {
        return dividendRatio;
    }

    public void setDividendRatio(String dividendRatio) {
        this.dividendRatio = Double.parseDouble(dividendRatio);
    }

    public void setDividendRatio(double dividendRatio) {
        this.dividendRatio = dividendRatio;
    }

    public double getVolatility() {
        return volatility;
    }

    public void setVolatility(String volatility) {
        this.volatility = Double.parseDouble(volatility);
    }

    public void setVolatility(double volatility) {
        this.volatility = volatility;
    }
}
