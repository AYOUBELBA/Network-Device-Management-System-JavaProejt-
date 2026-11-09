package network;

public class ProtocolSimulator implements ManagementProtocol {
    private final String name;

    public ProtocolSimulator(String name) {
        this.name = name;
    }

    @Override
    public void open(String ip) {
        System.out.println("[" + name + "] open " + ip);
    }

    @Override
    public String send(String cmd) {
        return "[" + name + "] " + cmd + " -> OK";
    }

    @Override
    public void close() {
        System.out.println("[" + name + "] close");
    }
}
