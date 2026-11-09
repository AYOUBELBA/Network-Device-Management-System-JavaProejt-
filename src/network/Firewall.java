package network;
public class Firewall extends NetworkDevice {
    private String rules = "deny all";
    public Firewall(String id, String ip, ManagementProtocol p) { super(id, ip, p); }
    @Override public void reboot() {
        protocol.open(ipAddress); System.out.println(protocol.send("restart")); protocol.close();
    }
    @Override public String getInfo() { return "Firewall " + id + " (" + ipAddress + ")"; }
    @Override public void applyConfig(String cfg) { rules = cfg; }
    @Override public String backupConfig() { return rules; }
}
