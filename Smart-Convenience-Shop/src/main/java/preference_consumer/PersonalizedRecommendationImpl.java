package preference_consumer;

import preference_producer.CustomerPreferenceService;

public class PersonalizedRecommendationImpl implements PersonalizedRecommendation{
    private final CustomerPreferenceService customerPreferenceService;
    public PersonalizedRecommendationImpl(CustomerPreferenceService customerPreferenceService) {
        this.customerPreferenceService = customerPreferenceService;
    }

    @Override
    public String customerPreference(String email) {
        return customerPreferenceService.getPreferences(email);
    }

    @Override
    public String getDishRecommendations(String email) {
        return customerPreferenceService.recommendDishes(email);
    }
}
