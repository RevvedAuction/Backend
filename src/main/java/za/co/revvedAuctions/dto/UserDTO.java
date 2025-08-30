package za.co.revvedAuctions.dto;

public class UserDTO {

    private Long userID;
    private String userType;
    private String userFullName;
    private String userEmail;
    private String userPassword;

    public UserDTO() {}

    public UserDTO(Long userID, String userType, String userFullName, String userEmail, String userPassword) {
        this.userID = userID;
        this.userType = userType;
        this.userFullName = userFullName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    // getters & setters
    public Long getUserID() { return userID; }
    public void setUserID(Long userID) { this.userID = userID; }
    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }
    public String getUserFullName() { return userFullName; }
    public void setUserFullName(String userFullName) { this.userFullName = userFullName; }
    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    public String getUserPassword() { return userPassword; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }
}
