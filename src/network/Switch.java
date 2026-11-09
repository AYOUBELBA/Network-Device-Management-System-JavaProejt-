package network;
public class Switch extends NetworkDevice {
    private String vlans = "vlan1";
    public Switch(String id, String ip, ManagementProtocol p) { super(id, ip, p); }
    @Override public void reboot() {
        protocol.open(ipAddress); System.out.println(protocol.send("reload")); protocol.close();
    }
    @Override public String getInfo() { return "Switch " + id + " (" + ipAddress + ")"; }
    @Override public void applyConfig(String cfg) { vlans = cfg; }
    @Override public String backupConfig() { return vlans; }
}
