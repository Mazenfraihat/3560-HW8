package decorator;

/** Decorator: wraps a FoodItem and adds to it. It IS a FoodItem, so toppings stack. */
public abstract class ToppingDecorator implements FoodItem {
    protected final FoodItem item;

    protected ToppingDecorator(FoodItem item) {
        this.item = item;
    }

    protected abstract String getToppingName();

    protected abstract double getToppingPrice();

    @Override
    public String getDescription() {
        return item.getDescription() + ", " + getToppingName();
    }

    @Override
    public double getCost() {
        return item.getCost() + getToppingPrice();
    }
}