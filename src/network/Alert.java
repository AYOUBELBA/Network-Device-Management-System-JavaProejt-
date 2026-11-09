package network;
public class Alert {
    private final String channel;
    private final String severity;
    private final String message;

    public Alert(String channel, String severity, String message) {
        this.channel = channel;
        this.severity = severity;
        this.message = message;
    }

    public void send() {
        System.out.println("[" + channel + "][" + severity + "] " + message);
    }
}
