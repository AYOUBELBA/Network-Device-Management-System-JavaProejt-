public class Main {
    public static void main(String[] args) {
        String password = "mohamed1234";
        String hashedpassword = hashPassword(password);
        User user1 = new User(1, "mohamed", "mohamed.test@gmail.com", hashedpassword, "admin");
        Device device1 = new Device(1, "Laptop", "192.168.1.100", "Computer", "Windows 10");
        Log log1 = new Log(1, user1.getId(), device1.getId(), "192.168.1.100", "Login", "Success");

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

    }
    public static String hashPassword(String password) {
        return Integer.toHexString(password.hashCode());
    }
}