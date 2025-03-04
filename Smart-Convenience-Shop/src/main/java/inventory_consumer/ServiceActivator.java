package inventory_consumer;

import inventory_producer.InventoryService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import java.util.Scanner;

public class ServiceActivator implements BundleActivator {
    private ServiceReference<InventoryService> serviceReference;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("...STARTING STOCK NOTIFICATION CONSUMER...");

        serviceReference = context.getServiceReference(InventoryService.class);

        if (serviceReference != null) {
            InventoryService inventoryService = context.getService(serviceReference);
            System.out.println("✅ Inventory Service FOUND in OSGi Registry.");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("\nEnter item to purchase (or type 'exit' to stop): ");
                String item = scanner.nextLine();

                if (item.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                inventoryService.purchaseItem(item, quantity);

                // Check stock levels
                System.out.println(inventoryService.getLowStockLevels());
            }

            scanner.close();
        } else {
            System.out.println("❌ Inventory Service NOT FOUND in OSGi Registry.");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        if (serviceReference != null) {
            context.ungetService(serviceReference);
        }
        System.out.println("❌ Stock Notification Consumer STOPPED.");
    }
}