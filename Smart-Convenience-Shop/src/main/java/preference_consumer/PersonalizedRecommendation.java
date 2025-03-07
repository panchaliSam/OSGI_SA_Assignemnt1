package preference_consumer;

public interface PersonalizedRecommendation {
    String customerPreference(String email);
    String getDishRecommendations(String email);
}
