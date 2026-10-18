package bridge;

public class PushChannel implements NotificationChannel {

    @Override
    public String send(String message) {
        String output = "[PUSH] " + message;
        System.out.println(output);
        return output;
    }

    @Override
    public String getChannelName() {
        return "PUSH";
    }
}