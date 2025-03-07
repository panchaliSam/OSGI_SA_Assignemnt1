package preference_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {
    private ServiceRegistration<CustomerPreferenceService> serviceRegistration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("...STARTING PREFERENCE PRODUCER...");

        // Create an instance of CustomerPreferenceServiceImpl
        CustomerPreferenceService preferencesService = new CustomerPreferenceServiceImpl();

        // Register the service under CustomerPreferenceService
        serviceRegistration = context.registerService(CustomerPreferenceService.class, preferencesService, null);

        if (serviceRegistration != null) {
            System.out.println("✅ Customer Preference Service REGISTERED.");
        } else {
            System.out.println("❌ Failed to register Customer Preference Service.");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        if (serviceRegistration != null) {
            serviceRegistration.unregister();
            System.out.println("❌ Customer Preference Service UNREGISTERED.");
        }
    }
}
