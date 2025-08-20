package za.co.revvedAuctions.domain;
/* Admin.java
   Admin Entity Class using Builder Pattern
   Author: Zintle Mgqongose 214280829
   Date: 11 May 2025
*/
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import za.co.revvedAuctions.util.Helper;

import java.time.LocalDate;


@Entity
public class Admin {
    @Id
    @Column(name = "adminID", unique = true, nullable = false)
    private String adminId;
    private String fullName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;
    private String password;
    private String phoneNumber;
    private String role; // e.g., "System Admin", "Moderator"
    private boolean isActive;
    private LocalDate dateCreated;

    protected Admin() {
    }

    protected Admin(Builder builder) {
        this.adminId = builder.adminId;
        this.fullName = builder.fullName;
        this.email = builder.email;
        this.password = builder.password;
        this.phoneNumber = builder.phoneNumber;
        this.role = builder.role;
        this.isActive = builder.isActive;
        this.dateCreated = builder.dateCreated;
    }

    public String getAdminId() {
        return adminId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public boolean isActive() {
        return isActive;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='***'" + // Masked password
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role='" + role + '\'' +
                ", isActive=" + isActive +
                ", dateCreated=" + dateCreated +
                '}';
    }

    public static class Builder {
        private String adminId;
        private String fullName;
        private String email;
        private String password;
        private String phoneNumber;
        private String role; // e.g., "System Admin", "Moderator"
        private boolean isActive;
        private LocalDate dateCreated;

        public Builder setAdminId(String adminId) {
            this.adminId = adminId;
            return this;
        }

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setEmail(String email) {
            if (!Helper.isValidEmail(email)) {
                throw new IllegalArgumentException("Invalid email format: " + email);
            }
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder setActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder setDateCreated(LocalDate dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public Builder copy(Admin admin) {
            this.adminId = admin.adminId;
            this.fullName = admin.fullName;
            this.email = admin.email;
            this.password = admin.password;
            this.phoneNumber = admin.phoneNumber;
            this.role = admin.role;
            this.isActive = admin.isActive;
            this.dateCreated = admin.dateCreated;
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }
}