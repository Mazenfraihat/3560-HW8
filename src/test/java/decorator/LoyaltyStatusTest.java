
package decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoyaltyStatusTest {
    private static final double DELTA = 0.001;

    @Test
    void getLevel() {
        assertEquals(LoyaltyStatus.Level.GOLD, new LoyaltyStatus(LoyaltyStatus.Level.GOLD).getLevel());
    }

    @Test
    void discountRates() {
        assertEquals(0.00, LoyaltyStatus.Level.NONE.getDiscountRate(), DELTA);
        assertEquals(0.05, LoyaltyStatus.Level.SILVER.getDiscountRate(), DELTA);
        assertEquals(0.10, LoyaltyStatus.Level.GOLD.getDiscountRate(), DELTA);
        assertEquals(0.15, LoyaltyStatus.Level.PLATINUM.getDiscountRate(), DELTA);
    }

    @Test
    void applyDiscount() {
        assertEquals(100.0, new LoyaltyStatus(LoyaltyStatus.Level.NONE).applyDiscount(100), DELTA);
        assertEquals(95.0, new LoyaltyStatus(LoyaltyStatus.Level.SILVER).applyDiscount(100), DELTA);
        assertEquals(90.0, new LoyaltyStatus(LoyaltyStatus.Level.GOLD).applyDiscount(100), DELTA);
        assertEquals(85.0, new LoyaltyStatus(LoyaltyStatus.Level.PLATINUM).applyDiscount(100), DELTA);
    }

    @Test
    void discountOnRealOrder() {
        Order order = new Order();
        order.addItem(new Cheese(new Burger())); // 9.99
        order.addItem(new Fries());              // 3.49
        double total = new LoyaltyStatus(LoyaltyStatus.Level.GOLD).applyDiscount(order.getTotalCost());
        assertEquals(13.48 * 0.90, total, DELTA);
    }
}