package service;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final List<User> users = new ArrayList<>();
    private int nextId = 1;

    public User createUser(String username, String email,String pwdhash, String role) {

        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        if (findByUsername(username) != null) {
            throw new IllegalArgumentException("Username already exists");
        }

        User user = new User(nextId++, username, email, pwdhash, role);
        users.add(user);

        return user;
    }

    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public boolean updateEmail(int id, String newEmail) {
        User user = findById(id);

        if (user == null || newEmail == null || newEmail.isBlank()) {
            return false;
        }

        user.updateEmail(newEmail);
        return true;
    }

    public boolean changePassword(int id, String newPwdHash) {
        User user = findById(id);

        if (user == null || newPwdHash == null || newPwdHash.isBlank()) {
            return false;
        }

        user.chgpwd(newPwdHash);
        return true;
    }

    public boolean deactivateUser(int id) {
        User user = findById(id);

        if (user == null) {
            return false;
        }

        user.deactivate();
        return true;
    }

    public boolean activateUser(int id) {
        User user = findById(id);

        if (user == null) {
            return false;
        }

        user.activate();
        return true;
    }

    public boolean deleteUser(int id) {
        User user = findById(id);

        if (user == null) {
            return false;
        }

        users.remove(user);
        return true;
    }
}
