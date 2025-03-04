package inventory_producer;

import java.util.HashMap;
import java.util.Map;

public class InventoryServiceImplementation implements InventoryService {
    private final Map<String, Integer> inventory;

    public InventoryServiceImplementation() {
        inventory = new HashMap<>();
        inventory.put("Apple", 30);
        inventory.put("Banana", 25);
        inventory.put("Orange", 40);
    }

    @Override
    public String getLowStockLevels() {
        StringBuilder lowStockItems = new StringBuilder("Low stock items:\n");
        boolean lowStockFound = false;

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            if(entry.getValue() < 20){
                lowStockFound = true;
                lowStockItems.append("⚠️").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
        }
        return lowStockFound ? lowStockItems.toString() : "✅ Stock levels are sufficient";
    }

    @Override
    public void purchaseItem(String itemName, int quantity) {
        if (inventory.containsKey(itemName)) {
            int currentStock = inventory.get(itemName);
            if (currentStock >= quantity) {
                inventory.put(itemName, currentStock - quantity);
                System.out.println("✅ Successfully purchased " + quantity + " " + itemName + "(s). \nRemaining stock: " + inventory.get(itemName));
            } else {
                System.out.println("❌ Not enough stock! Only " + currentStock + " " + itemName + "(s) available.");
            }
        } else {
            System.out.println("❌ Item not found in inventory.");
        }
    }
}