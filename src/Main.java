
import model.User;
import model.Device;
import model.Log;
import service.UserService;
import service.DeviceService;
import service.LogService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        DeviceService deviceService = new DeviceService();
        LogService logService = new LogService();

        String password = "mohamed1234";
        String hashedPassword = hashPassword(password);

        User user1 = userService.createUser(
            "mohamed",
            "mohamed.test@gmail.com",
            hashedPassword,
            "admin"
        );

        Device device1 = deviceService.addDevice(
            "Laptop",
            "192.168.1.100",
            "Computer",
            "Windows 10"
        );

        Log log1 = logService.createLog(
            user1.getId(),
            device1.getId(),
            "192.168.1.100",
            "Login",
            "Success"
        );

        System.out.println("User Information:");
        System.out.println("ID: " + user1.getId());
        System.out.println("Username: " + user1.getUsername());
        System.out.println("Email: " + user1.getEmail());
        System.out.println("Role: " + user1.getRole());

        System.out.println("**********************************");

        System.out.println("Device Information:");
        device1.displayDeviceInfo();

        System.out.println("**********************************");

        System.out.println("Log Information:");
        log1.displayLogInfo();

        System.out.println("**********************************");

        System.out.println("Testing Services:");

        System.out.println("Total Users: " + userService.getAllUsers().size());
        System.out.println("Total Devices: " + deviceService.getAllDevices().size());
        System.out.println("Total Logs: " + logService.getAllLogs().size());

        System.out.println("**********************************");

        System.out.println("Searching Logs for User " + user1.getUsername() + ":");
        for (Log log : logService.getLogsByUserId(user1.getId())) {
            log.displayLogInfo();
        }

        System.out.println("**********************************");

        System.out.println("Updating Device Name:");
        deviceService.updateName(device1.getId(), "Office Laptop");
        device1.displayDeviceInfo();

        System.out.println("**********************************");

        System.out.println("Updating Log Status:");
        logService.updateStatus(log1.getId(), "Reviewed");
        log1.displayLogInfo();
    }

    public static String hashPassword(String password) {
        return Integer.toHexString(password.hashCode());
    }
}
