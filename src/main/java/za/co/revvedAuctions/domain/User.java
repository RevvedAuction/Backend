package za.co.revvedAuctions.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/*
User.java
User POJO class
Author: Caitlin Malan (230426271)
*/

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userID;

    @Column(name = "user_type", nullable = false, length = 45)
    private String userType;

    @Column(name = "full_name", nullable = false, length = 255)
    private String userFullName;

    @Column(name = "email", unique = true, nullable = false, length = 255)
    private String userEmail;

    @Column(name = "password", nullable = false, length = 255)
    private String userPassword;

    @Column(name = "verification_code")
    private String verificationCode;

    @Column(name = "verification_expiration")
    private LocalDateTime verificationCodeExpiresAt;

    private boolean enabled;

    public User() {}

    private User(Builder builder) {
        this.userID = builder.userID;
        this.userType = builder.userType;
        this.userFullName = builder.userFullName;
        this.userEmail = builder.userEmail;
        this.userPassword = builder.userPassword;
        this.verificationCode = builder.verificationCode;
        this.verificationCodeExpiresAt = builder.verificationCodeExpiresAt;
        this.enabled = builder.enabled;
    }


    public Long getUserID() { return userID; }
    public String getUserType() { return userType; }
    public String getUserFullName() { return userFullName; }
    public String getUserEmail() { return userEmail; }
    public String getUserPassword() { return userPassword; }
    public String getVerificationCode() { return verificationCode; }
    public LocalDateTime getVerificationCodeExpiresAt() { return verificationCodeExpiresAt; }
    public boolean isEnabled() { return enabled; }


    public void setVerificationCode(String verificationCode) { this.verificationCode = verificationCode; }
    public void setVerificationCodeExpiresAt(LocalDateTime expiresAt) { this.verificationCodeExpiresAt = expiresAt; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }


    public static class Builder {
        private Long userID;
        private String userType;
        private String userFullName;
        private String userEmail;
        private String userPassword;
        private String verificationCode;
        private LocalDateTime verificationCodeExpiresAt;
        private boolean enabled;

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

        public Builder setVerificationCode(String code) {
            this.verificationCode = code;
            return this;
        }

        public Builder setVerificationCodeExpiresAt(LocalDateTime expiresAt) {
            this.verificationCodeExpiresAt = expiresAt;
            return this;
        }

        public Builder setEnabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder copy(User user) {
            this.userID = user.getUserID();
            this.userType = user.getUserType();
            this.userFullName = user.getUserFullName();
            this.userEmail = user.getUserEmail();
            this.userPassword = user.getUserPassword();
            this.verificationCode = user.getVerificationCode();
            this.verificationCodeExpiresAt = user.getVerificationCodeExpiresAt();
            this.enabled = user.isEnabled();
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
