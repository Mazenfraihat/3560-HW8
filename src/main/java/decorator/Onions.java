package decorator;

public class Onions extends ToppingDecorator {

    public Onions(FoodItem item) {
        super(item);
    }

    @Override
    protected String getToppingName() {
        return "Onions";
    }

    @Override
    protected double getToppingPrice() {
        return 0.50;
    }
}