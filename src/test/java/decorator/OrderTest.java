package decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderTest {
    private static final double DELTA = 0.001;

    @Test
    void addItemAndGetItems() {
        Order order = new Order();
        assertTrue(order.getItems().isEmpty());
        order.addItem(new Burger());
        order.addItem(new Fries());
        assertEquals(2, order.getItems().size());
    }

    @Test
    void emptyOrderTotalIsZero() {
        assertEquals(0.0, new Order().getTotalCost(), DELTA);
    }

    @Test
    void totalIncludesToppings() {
        Order order = new Order();
        order.addItem(new Cheese(new Ketchup(new Burger()))); // 10.24
        order.addItem(new Ketchup(new Fries()));              // 3.74
        assertEquals(13.98, order.getTotalCost(), DELTA);
    }

    @Test
    void printReceiptRuns() {
        Order order = new Order();
        order.addItem(new HotDog());
        order.printReceipt();
    }
}