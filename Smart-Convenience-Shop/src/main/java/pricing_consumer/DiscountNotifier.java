package pricing_consumer;

public class DiscountNotifier {
    public void applyDiscount(String pricingDetails,boolean isDiscounted,boolean isBundleOffer) {
        System.out.println("Received pricing details: " + pricingDetails);
        if(pricingDetails.contains("Banana:0.50")){
            System.out.println("Applying discount 10% For Banana! New Price:$0.45");
        }
        if(isDiscounted){
            System.out.println("Applying discount 10% For All Items! New Price:$0.90");
        }
        if(isBundleOffer){
            System.out.println("Applying Bundle Offer! New Price:$0.80");
        }
    }
}