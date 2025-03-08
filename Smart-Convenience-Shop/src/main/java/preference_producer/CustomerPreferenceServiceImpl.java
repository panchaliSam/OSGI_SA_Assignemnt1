package preference_producer;

import java.util.HashMap;
import java.util.Map;

public class CustomerPreferenceServiceImpl implements CustomerPreferenceService {
    private final Map<String,String> customerPreference;
    private final Map<String, String> dishRecommendations;

    public CustomerPreferenceServiceImpl() {
        customerPreference = new HashMap<>();
        dishRecommendations = new HashMap<>();

        // Sample dish recommendations
        dishRecommendations.put("Vegan", "🌱 Vegan Salad, Tofu Stir-Fry");
        dishRecommendations.put("Gluten-Free", "🍲 Quinoa Bowl, Grilled Chicken");
        dishRecommendations.put("Low-Sugar", "🍓 Berry Smoothie, Sugar-Free Cake");
    }

    @Override
    public String getPreferences(String email) {
        return customerPreference.getOrDefault(email, "No preferences set.");
    }
    @Override
    public void setPreference(String email, String preference) {
        customerPreference.put(email, preference);
        System.out.println("✅ Preference updated: " + email + " → " + preference);
    }
    @Override
    public String analyzePreferences() {
        Map<String, Integer> preferenceCount = new HashMap<>();
        for (String preference : customerPreference.values()) {
            preferenceCount.put(preference, preferenceCount.getOrDefault(preference, 0) + 1);
        }

        StringBuilder analysisResult = new StringBuilder("📊 Customer Preference Analysis:\n");
        for (Map.Entry<String, Integer> entry : preferenceCount.entrySet()) {
            analysisResult.append("• ").append(entry.getKey()).append(": ").append(entry.getValue()).append(" users\n");
        }

        return analysisResult.toString();
    }

    @Override
    public String recommendDishes(String email) {
        String preference = getPreferences(email);
        return dishRecommendations.getOrDefault(preference, "🍽 No recommendation available.");
    }
}
