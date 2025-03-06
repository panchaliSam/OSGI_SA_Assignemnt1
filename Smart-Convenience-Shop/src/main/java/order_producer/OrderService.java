package order_producer;

public interface OrderService {
    String placeOrder(String customerName, String itemName, int quantity);
    String getOrderDetails(int orderId);
}
