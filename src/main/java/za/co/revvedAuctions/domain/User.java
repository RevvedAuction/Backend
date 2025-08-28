package za.co.revvedAuctions.domain;

import jakarta.persistence.*;

/*
User.java
User POJO class
Author: Caitlin Malan (230426271)
*/

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    private Long userID;

    @Column(name = "user_type", nullable = false)
    private String userType;

    @Column(name = "full_name", nullable = false)
    private String userFullName;

    @Column(name = "email", unique = true, nullable = false)
    private String userEmail;

    @Column(name = "password", nullable = false)
    private String userPassword;


    public User() {
    }

    private User(Builder builder) {
        this.userID = builder.userID;
        this.userType = builder.userType;
        this.userFullName = builder.userFullName;
        this.userEmail = builder.userEmail;
        this.userPassword = builder.userPassword;
    }

    public Long getUserID() {
        return userID;
    }

    public String getUserType() {
        return userType;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", userType='" + userType + '\'' +
                ", userFullName='" + userFullName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    public static class Builder {
        private Long userID;
        private String userType;
        private String userFullName;
        private String userEmail;
        private String userPassword;

        public Builder setUserID(Long userID) {
            this.userID = userID;
            return this;
        }

        public Builder setUserType(String userType) {
            this.userType = userType;
            return this;
        }

        public Builder setUserFullName(String userFullName) {
            this.userFullName = userFullName;
            return this;
        }

        public Builder setUserEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public Builder setUserPassword(String userPassword) {
            this.userPassword = userPassword;
            return this;
        }

        public Builder copy(User user) {
            this.userID = user.getUserID();
            this.userType = user.getUserType();
            this.userFullName = user.getUserFullName();
            this.userEmail = user.getUserEmail();
            this.userPassword = user.getUserPassword();
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
