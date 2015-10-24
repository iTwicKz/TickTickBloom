package bloom.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StockMap {
    private HashMap<String, Stock> stockMap;

    public StockMap (ArrayList<String> securities) throws IllegalArgumentException {
        this.stockMap = new HashMap<>(50);
        this.parseSecurities(securities);
    }

    public void parseSecurities(ArrayList<String> securities) throws IllegalArgumentException {
        if (!securities.get(0).equals("SECURITIES_OUT")) {
            throw new IllegalArgumentException("Wrong output given. Requires SECURITIES_OUT, not " + securities.get(0));
        } else {
            securities.remove(0);
        }

        if (securities.size() % 4 != 0 && securities.size() <= 0) {
            throw new IllegalArgumentException("Wrong output given. Size " + securities.size() + " is wrong.");
        }

        for (int i = 0; i <= securities.size() - 4; i += 4 ) {
            ArrayList<String> stockInfo = new ArrayList<String>(securities.subList(i, i+4));
            this.stockMap.put(stockInfo.get(0), new Stock(stockInfo));
        }
    }

    public String toString() {
        String out = "";
        for (Map.Entry<String, Stock> entry: this.stockMap.entrySet()) {
            out += entry.getKey() + " : ";
            out += entry.getValue();
            out += "\n";
        }
        return out;
    }
}