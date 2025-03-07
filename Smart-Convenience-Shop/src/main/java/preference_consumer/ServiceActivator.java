package preference_consumer;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import preference_producer.CustomerPreferenceService;
public class ServiceActivator implements BundleActivator{
    private ServiceRegistration<PersonalizedRecommendation> serviceRegistration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("...STARTING PREFERENCE CONSUMER...");

        // Retrieve the CustomerPreferenceService from the service registry
        ServiceReference<CustomerPreferenceService> serviceReference = context.getServiceReference(CustomerPreferenceService.class);
        if (serviceReference != null) {
            // Get the service from the registry
            CustomerPreferenceService customerPreferenceService = context.getService(serviceReference);

            // Create the PersonalizedRecommendation implementation
            PersonalizedRecommendation personalizedRecommendation = new PersonalizedRecommendationImpl(customerPreferenceService);

            // Register the PersonalizedRecommendation service
            serviceRegistration = context.registerService(PersonalizedRecommendation.class, personalizedRecommendation, null);

            System.out.println("✅ Personalized Recommendation Service REGISTERED.");
        } else {
            System.out.println("❌ Customer Preference Service not found.");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        if (serviceRegistration != null) {
            serviceRegistration.unregister();
            System.out.println("❌ Personalized Recommendation Service UNREGISTERED.");
        }
    }
}
