package model;
import java.time.LocalDateTime;

public class User{
    private int id;
    private String username;
    private String email;
    private String pwdhash;
    private String role;
    private LocalDateTime createdAt;
    private boolean isActive;

    public User(int id, String username, String email, String pwdhash, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.pwdhash = pwdhash;
        this.role = role;
        this.isActive = true;
        this.createdAt = LocalDateTime.now();
    }
    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPwdhash() {
        return pwdhash;
    }
    public String getRole() {
        return role;
    }
    public boolean isActive() {
        return isActive;
    }
    public void updateEmail(String email) {
        this.email = email;
    }
    public void chgpwd(String pwdhash) {
        this.pwdhash = pwdhash;
    }
    public void deactivate() {
        this.isActive = false;
    }
    public void activate() {
        this.isActive = true;
    }
}