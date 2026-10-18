package bridge;

/** Implementor: HOW a message is delivered. */
public interface NotificationChannel {
    String send(String message);

    String getChannelName();
}