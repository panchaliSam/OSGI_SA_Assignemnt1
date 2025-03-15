package pricing_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {
    private ServiceRegistration<PricingService> registration;

    @Override
    public void start(BundleContext context) throws Exception {
        PricingService service = new PricingServiceImplementation();
        registration = context.registerService(PricingService.class, service, null);
        System.out.println("Pricing Service Registered");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        registration.unregister();
        System.out.println("Pricing Service Unregistered");
    }
}