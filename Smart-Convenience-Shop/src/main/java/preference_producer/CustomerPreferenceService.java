package preference_producer;

public interface CustomerPreferenceService {
    //get dietary preference for a given email
    String getPreferences(String email);

    // Set dietary preferences for a given email
    void setPreference(String email, String preference);

    // Analyze preferences across all users
    String analyzePreferences();

    // Recommend dishes based on user preferences
    String recommendDishes(String email);
}
