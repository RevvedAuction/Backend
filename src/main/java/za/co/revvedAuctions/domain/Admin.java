package za.co.revvedAuctions.domain;

import jakarta.persistence.*;
import za.co.revvedAuctions.util.Helper;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID adminId;
    private String fullName;
    private int adminNumber;
    private String email;
    private String password;
    private String phoneNumber;

    @Column(name = "fullname", nullable = false)
    private String fullName;
    @Column(name = "admin_Number", unique = true, nullable = false)
    private int adminNumber;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password", unique = true, nullable = false)
    private String password;
    @Column(name = "phonenumber", unique = true, nullable = false)
    private String phoneNumber;
    @Column(name = "date_created", nullable = false)
    private LocalDate dateCreated;

    protected Admin() {
    }

    protected Admin(Builder builder) {

        this.adminId = builder.adminId;
        this.adminNumber = builder.adminNumber;
        this.fullName = builder.fullName;
        this.email = builder.email;
        this.password = builder.password;
        this.phoneNumber = builder.phoneNumber;
        this.dateCreated = builder.dateCreated;
    }

    public UUID getAdminId() { return adminId; }
    public int getAdminNumber() {return adminNumber; }

    // Getters
    public UUID AdminId() { return adminId; }
    public int adminNumber() {return adminNumber; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getPhoneNumber() { return phoneNumber; }
    public LocalDate getDateCreated() { return dateCreated; }

    @Override
    public String toString() {
        return "Admin{" +
        ", adminNumber='" + adminNumber + '\'' +
        ", fullName='" + fullName + '\'' +
        ", email='" + email + '\'' +
        ", password='***'" + // Masked password
        ", phoneNumber='" + phoneNumber + '\'' +
        ", dateCreated=" + dateCreated +
        '}';
    }
    // Builder
    public static class Builder {
        private int adminNumber;
        private String fullName;
        private String email;
        private String password;
        private String phoneNumber;
        private LocalDate dateCreated;

        public Builder setAdminNumber(int adminNumber) {
            this.adminNumber = adminNumber;
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

        public Builder setDateCreated(LocalDate dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public Builder copy(za.co.revvedAuctions.domain.Admin admin) {
            this.fullName = admin.fullName;
            this.email = admin.email;
            this.password = admin.password;
            this.phoneNumber = admin.phoneNumber;
            this.dateCreated = admin.dateCreated;
            return this;
        }
        public za.co.revvedAuctions.domain.Admin build() { return new za.co.revvedAuctions.domain.Admin(this); }
    }
}