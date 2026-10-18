package bridge;

/** Abstraction: WHAT to say. Holds the channel (the bridge). */
public abstract class PaymentNotification {
    protected NotificationChannel channel;

    protected PaymentNotification(NotificationChannel channel) {
        this.channel = channel;
    }

    public String notifyCustomer(String customerName, double amount) {
        return channel.send(buildMessage(customerName, amount));
    }

    protected abstract String buildMessage(String customerName, double amount);

    public NotificationChannel getChannel() {
        return channel;
    }

    public void setChannel(NotificationChannel channel) {
        this.channel = channel;
    }
}