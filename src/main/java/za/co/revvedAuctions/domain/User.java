package za.co.revvedAuctions.domain;
/*
User.java

User POJO class

Author: L Matthews(221818340)

Date: 11 May 2025

*/
public class User {


    private String userID;
    private String userType;
    private String userName;
    private String userPassword;
    private boolean sessionStatus;
    private String carVIN;

    public User() {
    }

    private User(Builder builder) {
        this.userID = builder.userID;
        this.userType = builder.userType;
        this.userName = builder.userName;
        this.userPassword = builder.userPassword;
        this.sessionStatus = builder.sessionStatus;
        this.carVIN = builder.carVIN;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserType() {
        return userType;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public boolean isSessionStatus() {
        return sessionStatus;
    }

    public String getCarVIN() {
        return carVIN;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", userType='" + userType + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", sessionStatus=" + sessionStatus +
                ", carVIN='" + carVIN + '\'' +
                '}';
    }

    public static class Builder {
        private String userID;
        private String userType;
        private String userName;
        private String userPassword;
        private boolean sessionStatus;
        private String carVIN;

        public Builder setUserID(String userID) {
            this.userID = userID;
            return this;
        }

        public Builder setUserType(String userType) {
            this.userType = userType;
            return this;
        }

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setUserPassword(String userPassword) {
            this.userPassword = userPassword;
            return this;
        }

        public Builder setSessionStatus(boolean sessionStatus) {
            this.sessionStatus = sessionStatus;
            return this;
        }

        public Builder setCarVIN(String carVIN) {
            this.carVIN = carVIN;
            return this;
        }

        public Builder copy(User user) {
            this.userID = user.getUserID();
            this.userType = user.getUserType();
            this.userName = user.getUserName();
            this.userPassword = user.getUserPassword();
            this.sessionStatus = user.isSessionStatus();
            this.carVIN = user.getCarVIN();
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}
