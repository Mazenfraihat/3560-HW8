package decorator;

public class Fries implements FoodItem {
    private static final double BASE_PRICE = 3.49;

    @Override
    public String getDescription() {
        return "Fries";
    }

    @Override
    public double getCost() {
        return BASE_PRICE;
    }
}