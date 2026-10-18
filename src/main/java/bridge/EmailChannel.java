package bridge;

public class EmailChannel implements NotificationChannel {

    @Override
    public String send(String message) {
        String output = "[EMAIL] " + message;
        System.out.println(output);
        return output;
    }

    @Override
    public String getChannelName() {
        return "EMAIL";
    }
}