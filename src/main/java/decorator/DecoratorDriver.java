package decorator;

public class DecoratorDriver {
    public static void main(String[] args) {
        FoodItem cheeseBurger = new Cheese(new Ketchup(new Burger()));
        FoodItem loadedBurger = new Bacon(new Onions(new Cheese(new Burger())));
        FoodItem fries = new Ketchup(new Fries());
        FoodItem hotDog = new Onions(new Ketchup(new HotDog()));

        Order order = new Order();
        order.addItem(cheeseBurger);
        order.addItem(loadedBurger);
        order.addItem(fries);
        order.addItem(hotDog);

        System.out.println("===== Order =====");
        order.printReceipt();

        double subtotal = order.getTotalCost();
        System.out.println("\n===== Loyalty discounts =====");
        for (LoyaltyStatus.Level level : LoyaltyStatus.Level.values()) {
            LoyaltyStatus status = new LoyaltyStatus(level);
            System.out.println("  " + level + " (" + (int) (level.getDiscountRate() * 100) + "% off): $"
                    + String.format("%.2f", status.applyDiscount(subtotal)));
        }
    }
}