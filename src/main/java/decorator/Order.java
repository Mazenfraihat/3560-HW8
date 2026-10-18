package decorator;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<FoodItem> items = new ArrayList<>();

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public List<FoodItem> getItems() {
        return new ArrayList<>(items);
    }

    public double getTotalCost() {
        double total = 0;
        for (FoodItem item : items) {
            total += item.getCost();
        }
        return total;
    }

    public void printReceipt() {
        for (FoodItem item : items) {
            System.out.println("  " + item.getDescription() + " -> $" + String.format("%.2f", item.getCost()));
        }
        System.out.println("  Subtotal: $" + String.format("%.2f", getTotalCost()));
    }
}