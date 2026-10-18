package decorator;

public class Burger implements FoodItem {
    private static final double BASE_PRICE = 8.99;

    @Override
    public String getDescription() {
        return "Burger";
    }

    @Override
    public double getCost() {
        return BASE_PRICE;
    }
}