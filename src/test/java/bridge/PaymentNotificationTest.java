package bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PaymentNotificationTest {

    @Test
    void onlineBuildMessageIncludesMethodAndAmount() {
        OnlinePaymentNotification p = new OnlinePaymentNotification(new EmailChannel(), "PayPal");
        assertEquals("Hi Mazen, your online payment of $59.99 via PayPal was successful.",
                p.buildMessage("Mazen", 59.99));
    }

    @Test
    void onlineGetMethod() {
        assertEquals("Credit Card", new OnlinePaymentNotification(new SmsChannel(), "Credit Card").getMethod());
    }

    @Test
    void onlineWithEmail() {
        String out = new OnlinePaymentNotification(new EmailChannel(), "Credit Card").notifyCustomer("Mazen", 10);
        assertTrue(out.startsWith("[EMAIL]"));
        assertTrue(out.contains("Credit Card"));
    }

    @Test
    void onlineWithSms() {
        String out = new OnlinePaymentNotification(new SmsChannel(), "PayPal").notifyCustomer("Sara", 10);
        assertTrue(out.startsWith("[SMS]"));
    }

    @Test
    void cashBuildMessage() {
        CashOnDeliveryPayment p = new CashOnDeliveryPayment(new EmailChannel());
        assertEquals("Hi Omar, your order is confirmed. Please have $35.50 in cash ready at delivery.",
                p.buildMessage("Omar", 35.5));
    }

    @Test
    void cashWithEmailAndSms() {
        assertTrue(new CashOnDeliveryPayment(new EmailChannel()).notifyCustomer("Omar", 5).startsWith("[EMAIL]"));
        assertTrue(new CashOnDeliveryPayment(new SmsChannel()).notifyCustomer("Lina", 5).startsWith("[SMS]"));
    }

    @Test
    void bitcoinBuildMessageIncludesWallet() {
        BitcoinPayment p = new BitcoinPayment(new EmailChannel(), "bc1abc");
        assertTrue(p.buildMessage("Yusuf", 250).contains("bc1abc"));
    }

    @Test
    void bitcoinGetWalletAddress() {
        assertEquals("bc1abc", new BitcoinPayment(new SmsChannel(), "bc1abc").getWalletAddress());
    }

    @Test
    void bitcoinWithEmailAndSms() {
        assertTrue(new BitcoinPayment(new EmailChannel(), "w").notifyCustomer("Y", 1).startsWith("[EMAIL]"));
        assertTrue(new BitcoinPayment(new SmsChannel(), "w").notifyCustomer("H", 1).startsWith("[SMS]"));
    }

    @Test
    void pushWorksWithExistingPaymentTypes() {
        assertTrue(new OnlinePaymentNotification(new PushChannel(), "PayPal").notifyCustomer("A", 1).startsWith("[PUSH]"));
        assertTrue(new CashOnDeliveryPayment(new PushChannel()).notifyCustomer("M", 1).startsWith("[PUSH]"));
    }

    @Test
    void getAndSetChannel() {
        NotificationChannel sms = new SmsChannel();
        PaymentNotification p = new CashOnDeliveryPayment(new EmailChannel());
        p.setChannel(sms);
        assertSame(sms, p.getChannel());
        assertTrue(p.notifyCustomer("Omar", 1).startsWith("[SMS]"));
    }
}