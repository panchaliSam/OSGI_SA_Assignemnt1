package pricing_producer;

public interface PricingService {
    String getPricingDetails();
    void updateStock(String productName, int quantity);
    void applyPricing();
}