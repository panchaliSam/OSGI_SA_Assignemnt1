package order_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class OrderServiceActivator implements BundleActivator {
    private ServiceRegistration<OrderService> orderServiceRegistration;


    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("...STARTING ORDER PRODUCER...");
        OrderService orderService = new OrderServiceImplementation();
        orderServiceRegistration = context.registerService(OrderService.class, orderService, null);
        System.out.println("✅ Order Service Registered.");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        orderServiceRegistration.unregister();
        System.out.println("...STOPPING ORDER PRODUCER...");
    }
}
