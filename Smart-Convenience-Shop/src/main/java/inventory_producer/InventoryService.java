package inventory_producer;

public interface InventoryService {
    String getLowStockLevels();
    void purchaseItem(String itemName, int quantity);
}