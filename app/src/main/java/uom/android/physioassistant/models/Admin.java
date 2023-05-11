package uom.android.physioassistant.models;

public class Admin extends User{
    private String username;

    public Admin(String username, String password) {
        super(password);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
