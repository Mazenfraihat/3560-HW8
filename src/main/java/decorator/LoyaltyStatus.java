package decorator;

public class LoyaltyStatus {

    public enum Level {
        NONE(0.00), SILVER(0.05), GOLD(0.10), PLATINUM(0.15);

        private final double discountRate;

        Level(double discountRate) {
            this.discountRate = discountRate;
        }

        public double getDiscountRate() {
            return discountRate;
        }
    }

    private final Level level;

    public LoyaltyStatus(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public double applyDiscount(double total) {
        return total * (1 - level.getDiscountRate());
    }
}