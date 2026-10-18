package bridge;

public class OnlinePaymentNotification extends PaymentNotification {
    private final String method;

    public OnlinePaymentNotification(NotificationChannel channel, String method) {
        super(channel);
        this.method = method;
    }

    @Override
    protected String buildMessage(String customerName, double amount) {
        return "Hi " + customerName + ", your online payment of $"
                + String.format("%.2f", amount) + " via " + method + " was successful.";
    }

    public String getMethod() {
        return method;
    }
}