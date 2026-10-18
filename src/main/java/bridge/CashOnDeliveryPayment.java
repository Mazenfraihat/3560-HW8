package bridge;

public class CashOnDeliveryPayment extends PaymentNotification {

    public CashOnDeliveryPayment(NotificationChannel channel) {
        super(channel);
    }

    @Override
    protected String buildMessage(String customerName, double amount) {
        return "Hi " + customerName + ", your order is confirmed. Please have $"
                + String.format("%.2f", amount) + " in cash ready at delivery.";
    }
}