import java.time.LocalDateTime;

public class Log{
    private int id;
    private int userId;
    private int deviceId;
    private String sourceIp;
    private LocalDateTime timestamp;
    private String Operation;
    private String Status;

    public Log(int id, int userId, int deviceId, String sourceIp, String Operation, String Status) {
        this.id = id;
        this.userId = userId;
        this.deviceId = deviceId;
        this.sourceIp = sourceIp;
        this.timestamp = LocalDateTime.now();
        this.Operation = Operation;
        this.Status = Status;
    }

    public int getId() {
        return id;
    }
    public int getUserId() {
        return userId;
    }
    public int getDeviceId() {
        return deviceId;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public String getOperation() {
        return Operation;
    }
    public String getSourceIp() {
        return sourceIp;
    }
    public String getStatus() {
        return Status;
    }
    public void updateStatus(String Status) {
        this.Status = Status;
    }
    public void displayLogInfo() {
        System.out.println("Log ID: " + id);
        System.out.println("User ID: " + userId);
        System.out.println("Device ID: " + deviceId);
        System.out.println("Source IP: " + sourceIp);
        System.out.println("Timestamp: " + timestamp);
        System.out.println("Operation: " + Operation);
        System.out.println("Status: " + Status);
    }
}
