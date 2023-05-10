package uom.android.physioassistant.backend.responses;

import uom.android.physioassistant.models.User;

public class LoginResponse {
    private User user;
    private String errorMessage;
    private String userRole;

    public LoginResponse() {
    }

    public User getUser() {
        return user;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getUserRole() {
        return userRole;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "user=" + user +
                ", errorMessage='" + errorMessage + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
