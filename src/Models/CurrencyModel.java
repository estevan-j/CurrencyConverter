package Models;

import java.util.*;

public class CurrencyModel {
    private final String base;
    private HashMap<String, Float> rates;
    private List<String> moneys;
    public CurrencyModel(String base, HashMap<String, Float> rates) {
        this.base = base;
        this.rates = new HashMap<>();
        this.moneys = new ArrayList<>();
        for (Currencies money : Currencies.values()) {
            this.moneys.add(money.getCodigo());
        }
        for (Map.Entry<String, Float> entry : rates.entrySet()) {
            if (moneys.contains(entry.getKey())) {
                this.rates.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public double convertion(String to, Double amount) {
        return amount * rates.get(to);
    }

}
