
package bridge;

public class BridgeDriver {
    public static void main(String[] args) {
        NotificationChannel email = new EmailChannel();
        NotificationChannel sms = new SmsChannel();
        NotificationChannel push = new PushChannel();

        System.out.println("===== Part 1 =====");
        System.out.println("-- Online (Credit Card) + Email --");
        new OnlinePaymentNotification(email, "Credit Card").notifyCustomer("Mazen", 59.99);
        System.out.println("-- Online (PayPal) + SMS --");
        new OnlinePaymentNotification(sms, "PayPal").notifyCustomer("Sara", 120.00);
        System.out.println("-- Cash on Delivery + Email --");
        new CashOnDeliveryPayment(email).notifyCustomer("Omar", 35.50);
        System.out.println("-- Cash on Delivery + SMS --");
        new CashOnDeliveryPayment(sms).notifyCustomer("Lina", 18.25);

        System.out.println("\n===== Part 2: Bitcoin =====");
        System.out.println("-- Bitcoin + Email --");
        new BitcoinPayment(email, "bc1qxy2kgdygjrsqtzq2n0yrf2493p83kkf").notifyCustomer("Yusuf", 250.00);
        System.out.println("-- Bitcoin + SMS --");
        new BitcoinPayment(sms, "bc1qar0srrr7xfkvy5l643lydnw9re59gtzz").notifyCustomer("Huda", 75.00);

        System.out.println("\n===== Part 3: Push =====");
        System.out.println("-- Online (PayPal) + Push --");
        new OnlinePaymentNotification(push, "PayPal").notifyCustomer("Adam", 42.00);
        System.out.println("-- Cash on Delivery + Push --");
        new CashOnDeliveryPayment(push).notifyCustomer("Maryam", 22.75);
    }
}