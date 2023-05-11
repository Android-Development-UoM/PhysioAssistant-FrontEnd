package uom.android.physioassistant.models;

public class User {
    private String password;

    public User() {}

    public User(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
