package decorator;

public class Ketchup extends ToppingDecorator {

    public Ketchup(FoodItem item) {
        super(item);
    }

    @Override
    protected String getToppingName() {
        return "Ketchup";
    }

    @Override
    protected double getToppingPrice() {
        return 0.25;
    }
}