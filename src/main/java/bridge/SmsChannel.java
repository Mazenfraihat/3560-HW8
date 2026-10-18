package bridge;

public class SmsChannel implements NotificationChannel {

    @Override
    public String send(String message) {
        String output = "[SMS] " + message;
        System.out.println(output);
        return output;
    }

    @Override
    public String getChannelName() {
        return "SMS";
    }
}