package decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoodItemTest {
    private static final double DELTA = 0.001;

    @Test
    void burger() {
        assertEquals("Burger", new Burger().getDescription());
        assertEquals(8.99, new Burger().getCost(), DELTA);
    }

    @Test
    void fries() {
        assertEquals("Fries", new Fries().getDescription());
        assertEquals(3.49, new Fries().getCost(), DELTA);
    }

    @Test
    void hotDog() {
        assertEquals("Hot Dog", new HotDog().getDescription());
        assertEquals(4.99, new HotDog().getCost(), DELTA);
    }

    @Test
    void ketchup() {
        FoodItem item = new Ketchup(new Fries());
        assertEquals("Fries, Ketchup", item.getDescription());
        assertEquals(3.74, item.getCost(), DELTA);
    }

    @Test
    void cheese() {
        FoodItem item = new Cheese(new Burger());
        assertEquals("Burger, Cheese", item.getDescription());
        assertEquals(9.99, item.getCost(), DELTA);
    }

    @Test
    void onions() {
        FoodItem item = new Onions(new HotDog());
        assertEquals("Hot Dog, Onions", item.getDescription());
        assertEquals(5.49, item.getCost(), DELTA);
    }

    @Test
    void bacon() {
        FoodItem item = new Bacon(new Burger());
        assertEquals("Burger, Bacon", item.getDescription());
        assertEquals(10.74, item.getCost(), DELTA);
    }

    @Test
    void stackedToppings() {
        FoodItem item = new Bacon(new Onions(new Cheese(new Burger())));
        assertEquals("Burger, Cheese, Onions, Bacon", item.getDescription());
        assertEquals(8.99 + 1.00 + 0.50 + 1.75, item.getCost(), DELTA);
    }
}