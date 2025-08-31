package za.co.revvedAuctions.payload;

public class LoginMessage {

    String loginMessage;
    boolean loginStatus;

    public LoginMessage() {
    }

    public LoginMessage(String loginMessage, boolean loginStatus) {
        this.loginMessage = loginMessage;
        this.loginStatus = loginStatus;
    }

    public String getMessage() {
        return loginMessage;
    }

    public void setMessage(String message) {
        this.loginMessage = message;
    }

    public boolean isStatus() {
        return loginStatus;
    }

    public void setStatus(boolean status) {
        this.loginStatus = loginStatus;
    }
}
