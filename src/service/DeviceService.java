
package service;

import model.Device;
import java.util.ArrayList;
import java.util.List;

public class DeviceService {

    private final List<Device> devices = new ArrayList<>();
    private int nextId = 1;

    public Device addDevice(String name, String ipAddress, String deviceType, String os) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Device name cannot be empty");
        }

        if (ipAddress == null || ipAddress.isBlank()) {
            throw new IllegalArgumentException("IP address cannot be empty");
        }

        if (findByIpAddress(ipAddress) != null) {
            throw new IllegalArgumentException("IP address already exists");
        }

        Device device = new Device(nextId++, name, ipAddress, deviceType, os);
        devices.add(device);
        return device;
    }

    public Device findById(int id) {
        for (Device device : devices) {
            if (device.getId() == id) {
                return device;
            }
        }
        return null;
    }

    public Device findByIpAddress(String ipAddress) {
        for (Device device : devices) {
            if (device.getIpAdress().equalsIgnoreCase(ipAddress)) {
                return device;
            }
        }
        return null;
    }

    public List<Device> getAllDevices() {
        return new ArrayList<>(devices);
    }

    public List<Device> getActiveDevices() {
        List<Device> activeDevices = new ArrayList<>();

        for (Device device : devices) {
            if (device.isActive()) {
                activeDevices.add(device);
            }
        }

        return activeDevices;
    }

    public boolean updateName(int id, String name) {
        Device device = findById(id);

        if (device == null || name == null || name.isBlank()) {
            return false;
        }

        device.updateName(name);
        return true;
    }

    public boolean updateIpAddress(int id, String ipAddress) {
        Device device = findById(id);

        if (device == null || ipAddress == null || ipAddress.isBlank()) {
            return false;
        }

        Device existing = findByIpAddress(ipAddress);

        if (existing != null && existing.getId() != id) {
            return false;
        }

        device.updateIpAdress(ipAddress);
        return true;
    }

    public boolean updateOS(int id, String os) {
        Device device = findById(id);

        if (device == null || os == null || os.isBlank()) {
            return false;
        }

        device.updateOS(os);
        return true;
    }

    public boolean deactivateDevice(int id) {
        Device device = findById(id);

        if (device == null) {
            return false;
        }

        device.deactivate();
        return true;
    }

    public boolean activateDevice(int id) {
        Device device = findById(id);

        if (device == null) {
            return false;
        }

        device.activate();
        return true;
    }

    public boolean deleteDevice(int id) {
        Device device = findById(id);

        if (device == null) {
            return false;
        }

        devices.remove(device);
        return true;
    }
}
