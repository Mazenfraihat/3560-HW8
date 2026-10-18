package decorator;

public class HotDog implements FoodItem {
    private static final double BASE_PRICE = 4.99;

    @Override
    public String getDescription() {
        return "Hot Dog";
    }

    @Override
    public double getCost() {
        return BASE_PRICE;
    }
}