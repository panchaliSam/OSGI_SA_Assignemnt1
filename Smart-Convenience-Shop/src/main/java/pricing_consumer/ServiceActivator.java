package pricing_consumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import pricing_producer.PricingService;
import pricing_consumer.DiscountNotifier;

public class ServiceActivator implements BundleActivator {
    private ServiceReference<PricingService> serviceTracker;

    @Override
    public void start(BundleContext con) throws Exception {
        serviceTracker = con.getServiceReference(PricingService.class);

        if (serviceTracker != null) {
            PricingService service = con.getService(serviceTracker);
            if (service != null) {
                DiscountNotifier discountNotifier = new DiscountNotifier();
                boolean isDiscounted = true;
                boolean isBundleOffer = true;

                discountNotifier.applyDiscount(service.getPricingDetails(), isDiscounted, isBundleOffer);
            }
        } else {
            System.err.println("PricingService reference is null.");
        }

        System.out.println("Discount Notification Consumer Started");
    }

    @Override
    public void stop(BundleContext con) throws Exception {
        if (serviceTracker != null) {
            con.ungetService(serviceTracker);
        }
        System.out.println("Discount Notification Consumer Stopped");
    }
}