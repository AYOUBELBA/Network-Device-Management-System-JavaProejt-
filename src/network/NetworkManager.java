package network;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class NetworkManager {
    private final List<NetworkDevice> devices = new ArrayList<>();
    private final Set<String> deviceIds = new LinkedHashSet<>();
    private final Map<String, NetworkDevice> devicesById = new LinkedHashMap<>();

    public void addDevice(NetworkDevice d) {
        if (deviceIds.add(d.getId())) {
            devices.add(d);
            devicesById.put(d.getId(), d);
        }
    }

    public void removeDevice(String id) {
        if (deviceIds.remove(id)) {
            devices.removeIf(d -> d.getId().equals(id));
            devicesById.remove(id);
        }
    }

    public NetworkDevice[] getDevicesArray() {
        return devices.toArray(NetworkDevice[]::new);
    }

    public Set<String> getDeviceIds() {
        return new LinkedHashSet<>(deviceIds);
    }

    public void discover() {
        devices.stream()
                .forEach(d -> System.out.println(d.getInfo() + " -> " + d.getStatus()));
    }

    public List<NetworkDevice> getDevicesByStatus(String status) {
        return devices.stream()
                .filter(d -> d.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public Optional<NetworkDevice> findDevice(String id) {
        return Optional.ofNullable(devicesById.get(id));
    }

    public Map<String, NetworkDevice> getDevicesById() {
        return new LinkedHashMap<>(devicesById);
    }

    public void raiseAlert(Alert a) { a.send(); }
}
