package network;

public class Main {
    public static void main(String[] args) {
        NetworkManager nm = new NetworkManager();

        nm.addDevice(new Router("R1", "192.168.1.1", new ProtocolSimulator("SNMP")));
        nm.addDevice(new Switch("S1", "192.168.1.2", new ProtocolSimulator("SSH")));
        nm.addDevice(new Firewall("F1", "192.168.1.3", new ProtocolSimulator("SSH")));
        nm.discover();

        nm.raiseAlert(new Alert("EMAIL", "HIGH", "Router R1 CPU > 90%"));
        nm.raiseAlert(new Alert("SMS", "CRITICAL", "Firewall F1 down"));
    }
}
