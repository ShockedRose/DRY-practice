public class ProductService {
    private static final double DISCOUNT_RATE = 0.1;

    public double getDiscountedPriceA(double price) {
        return applyDiscount(price);
    }

    public double getDiscountedPriceB(double price) {
        return applyDiscount(price);
    }

    private double applyDiscount(double price) {
        return price - price * DISCOUNT_RATE;
    }
}