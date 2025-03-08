package preference_consumer;

import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import preference_producer.CustomerPreferenceService;

public class ServiceActivator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("...STARTING PREFERENCE CONSUMER...");

        // Wait for the Preference Producer to be registered
        while (true) {
            // Fetch the CustomerPreferenceService from the OSGi service registry
            CustomerPreferenceService customerPreferenceService =
                    (CustomerPreferenceService) context.getService(
                            context.getServiceReference(CustomerPreferenceService.class));

            if (customerPreferenceService != null) {
                // Successfully retrieved the CustomerPreferenceService
                System.out.println("✅ Personalized Recommendation Service REGISTERED.");

                // Initialize the Scanner to read user input
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter your email: ");
                String email = scanner.nextLine();

                System.out.println("Please enter your preference: ");
                String preference = scanner.nextLine();

                // Set the customer preference
                customerPreferenceService.setPreference(email, preference);

                System.out.println("Customer preference for " + email + " has been set to: " + preference);
                break;  // Exit the loop once done
            } else {
                System.out.println("Waiting for Customer Preference Service...");
                Thread.sleep(1000);  // Wait for the service to be available
            }
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("...STOPPING PREFERENCE CONSUMER...");
    }
}
