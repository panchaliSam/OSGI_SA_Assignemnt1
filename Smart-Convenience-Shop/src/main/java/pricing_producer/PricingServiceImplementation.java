package pricing_producer;

import java.util.HashMap;
import java.util.Map;

public class PricingServiceImplementation implements PricingService {
    private HashMap <String, Double> priceMap = new HashMap<>();
    private HashMap <String, Integer> stockMap = new HashMap<>();

    public PricingServiceImplementation() {
        // Initialize the priceMap with some default values
        priceMap.put("Apple", 1.00);
        priceMap.put("Orange", 0.75);
        priceMap.put("Banana",0.50);

        // Initialize the stockMap with some default values
        stockMap.put("Apple", 10);
        stockMap.put("Orange", 20);
        stockMap.put("Banana", 30);
    }

    @Override
    public String getPricingDetails() {
        StringBuilder sb = new StringBuilder("Pricing Details:\n");
        for (Map.Entry<String, Double> entry : priceMap.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public void updateStock(String product,int quantity) {
        if(stockMap.containsKey(product)){
            stockMap.put(product,stockMap.get(product) - quantity);
            applyPricing();
        }
    }

    @Override
    public void applyPricing() {
        for (String product : stockMap.keySet()) {
            int stock = stockMap.get(product);
            if(stock<5){
                priceMap.put(product,priceMap.get(product)*1.1);
            }else if(stock>15){
                priceMap.put(product,priceMap.get(product)*0.9);
            }
        }
    }

}