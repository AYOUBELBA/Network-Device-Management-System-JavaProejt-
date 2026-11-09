package network;
public class Router extends NetworkDevice {
    private String routingTable = "default";
    public Router(String id, String ip, ManagementProtocol p) { super(id, ip, p); }
    @Override public void reboot() {
        protocol.open(ipAddress); System.out.println(protocol.send("reboot")); protocol.close();
    }
    @Override public String getInfo() { return "Router " + id + " (" + ipAddress + ")"; }
    @Override public void applyConfig(String cfg) { routingTable = cfg; }
    @Override public String backupConfig() { return routingTable; }
}
