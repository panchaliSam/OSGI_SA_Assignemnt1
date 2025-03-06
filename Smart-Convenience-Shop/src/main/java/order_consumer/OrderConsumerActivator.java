package order_consumer;

import order_producer.OrderService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import java.util.Scanner;

public class OrderConsumerActivator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("...STARTING ORDER CONSUMER...");

        ServiceReference<OrderService> orderServiceReference = context.getServiceReference(OrderService.class);

        if (orderServiceReference != null){
            OrderService orderService = context.getService(orderServiceReference);
            Scanner scn = new Scanner(System.in);

            System.out.println("Enter customer name: ");
            String customerName = scn.nextLine();

            System.out.println("Enter item name: ");
            String itemName = scn.nextLine();

            System.out.println("Enter quantity: ");
            int quantity = scn.nextInt();
            scn.nextLine();

            String orderConfirmation = orderService.placeOrder(customerName, itemName, quantity);
            System.out.println(orderConfirmation);

            System.out.println("Enter OrderID to check details: ");
            int orderId = scn.nextInt();
            scn.nextLine();

            System.out.println(orderService.getOrderDetails(orderId));
        }else{
            System.out.println("Order not available");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception{
        System.out.println("Stopping Food Ordering Consumer");
    }
}
