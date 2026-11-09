package network;
import java.util.HashMap;
import java.util.Map;

public abstract class NetworkDevice {
    public static final String STATUS_UP = "UP";
    public static final String STATUS_DOWN = "DOWN";
    public static final String STATUS_DEGRADED = "DEGRADED";
    protected String id;
    protected String ipAddress;
    protected String status = STATUS_UP;
    protected ManagementProtocol protocol;

    protected NetworkDevice(String id, String ipAddress, ManagementProtocol protocol) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.protocol = protocol;
    }

    public abstract void reboot();
    public abstract String getInfo();
    public abstract void applyConfig(String cfg);
    public abstract String backupConfig();

    public String getId() { return id; }

    public String getStatus() { return status; }

    public Map<String, Double> collectMetrics() {
        Map<String, Double> m = new HashMap<>();
        m.put("cpu", Math.random() * 100);
        m.put("bandwidth", Math.random() * 1000);
        return m;
    }
}
