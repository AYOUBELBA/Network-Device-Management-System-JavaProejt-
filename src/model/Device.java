package model;
public class Device{
    private int id;
    private String name;
    private String IpAdress;
    private String Devicetype;
    private String OS;
    private boolean isActive;

    public Device(int id, String name, String IpAdress, String Devicetype, String OS) {
        this.id = id;
        this.name = name;
        this.IpAdress = IpAdress;
        this.Devicetype = Devicetype;
        this.OS = OS;
        this.isActive = true;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getIpAdress() {
        return IpAdress;
    }
    public String getDevicetype() {
        return Devicetype;
    }
    public String getOS() {
        return OS;
    }
    public boolean isActive() {
        return isActive;
    }
    public void updateName(String name) {
        this.name = name;
    }
    public void updateOS(String OS) {
        this.OS = OS;
    }
    public void updateIpAdress(String IpAdress) {
        this.IpAdress = IpAdress;
    }
    public void deactivate() {
        this.isActive = false;
    }
    public void activate() {
        this.isActive = true;
    }
    public void displayDeviceInfo() {
        System.out.println("Device ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("IP Address: " + IpAdress);
        System.out.println("Device Type: " + Devicetype);
        System.out.println("Operating System: " + OS);
        System.out.println("Active: " + isActive);
    }
}