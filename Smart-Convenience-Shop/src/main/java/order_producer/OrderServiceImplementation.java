package order_producer;

import java.util.HashMap;
import java.util.Map;

public class OrderServiceImplementation implements OrderService {

   private final Map<Integer, String> orders;
   private int orderCount=1;

   public OrderServiceImplementation() {
       orders = new HashMap<>();
   }

   @Override
    public String placeOrder(String customerName, String itemName, int quantity) {
       int orderId = orderCount++;
       String orderDetails = "🆔 Order ID: " + orderId + "\n👤 Customer: " + customerName +
               "\n🍽️ Item: " + itemName + "\n🔢 Quantity: " + quantity;

       orders.put(orderId, orderDetails);
       return "✅ Order Placed Successfully!\n" + orderDetails;

   }

   @Override
    public String getOrderDetails(int orderId) {
       return orders.getOrDefault(orderId, "❌ Order not found!");
   }

}
