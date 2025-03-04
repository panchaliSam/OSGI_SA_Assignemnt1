package inventory_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {
    private ServiceRegistration<InventoryService> serviceRegistration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("...STARTING INVENTORY PRODUCER...");

        InventoryService inventoryService = new InventoryServiceImplementation();
        serviceRegistration = context.registerService(InventoryService.class, inventoryService, null);

        if (serviceRegistration != null) {
            System.out.println("✅ Inventory Management Service REGISTERED.");
        } else {
            System.out.println("❌ Failed to register Inventory Management Service.");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        if (serviceRegistration != null) {
            serviceRegistration.unregister();
            System.out.println("❌ Inventory Management Service UNREGISTERED.");
        }
    }
}