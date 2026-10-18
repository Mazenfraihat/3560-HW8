package bridge;

public class BitcoinPayment extends PaymentNotification {
    private final String walletAddress;

    public BitcoinPayment(NotificationChannel channel, String walletAddress) {
        super(channel);
        this.walletAddress = walletAddress;
    }

    @Override
    protected String buildMessage(String customerName, double amount) {
        return "Hi " + customerName + ", we received your Bitcoin payment worth $"
                + String.format("%.2f", amount) + " from wallet " + walletAddress + ".";
    }

    public String getWalletAddress() {
        return walletAddress;
    }
}