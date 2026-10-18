package decorator;

public class Bacon extends ToppingDecorator {

    public Bacon(FoodItem item) {
        super(item);
    }

    @Override
    protected String getToppingName() {
        return "Bacon";
    }

    @Override
    protected double getToppingPrice() {
        return 1.75;
    }
}