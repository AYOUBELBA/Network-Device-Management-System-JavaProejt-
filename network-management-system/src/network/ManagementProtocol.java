package network;
public interface ManagementProtocol {
    void open(String ip);
    String send(String cmd);
    void close();
}
