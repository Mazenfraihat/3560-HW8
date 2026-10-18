package bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NotificationChannelTest {

    @Test
    void emailSendPrefixesMessage() {
        assertEquals("[EMAIL] hello", new EmailChannel().send("hello"));
    }

    @Test
    void emailChannelName() {
        assertEquals("EMAIL", new EmailChannel().getChannelName());
    }

    @Test
    void smsSendPrefixesMessage() {
        assertEquals("[SMS] hello", new SmsChannel().send("hello"));
    }

    @Test
    void smsChannelName() {
        assertEquals("SMS", new SmsChannel().getChannelName());
    }

    @Test
    void pushSendPrefixesMessage() {
        assertEquals("[PUSH] hello", new PushChannel().send("hello"));
    }

    @Test
    void pushChannelName() {
        assertEquals("PUSH", new PushChannel().getChannelName());
    }
}