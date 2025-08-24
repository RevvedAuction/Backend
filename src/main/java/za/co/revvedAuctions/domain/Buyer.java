package za.co.revvedAuctions.domain;

/* Buyer.java
   Buyer Entity Class using Builder Pattern
   Author: Zintle Mgqongose (214280829)
   Date: 11 May 2025
*/

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.util.Objects;


@Entity
public class Buyer {
    @Id
    @Column(name = "buyerID", unique = true, nullable = false)
    private String buyerId;

    @Column(name = "userID", nullable = false)
    private String userId;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    private String password;

    private String phoneNumber;

    private String preferredCarType;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    private boolean isVerified;

    protected Buyer() {
    }

    protected Buyer(Builder builder) {
        this.buyerId = builder.buyerId;
        this.userId = builder.userId;
        this.fullName = builder.fullName;
        this.email = builder.email;
        this.password = builder.password;
        this.phoneNumber = builder.phoneNumber;
        this.preferredCarType = builder.preferredCarType;
        this.paymentMethod = builder.paymentMethod;
        this.isVerified = builder.isVerified;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserId() {
        return userId;
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

    public String getPreferredCarType() {
        return preferredCarType;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "buyerId='" + buyerId + '\'' +
                ", userId='" + userId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", preferredCarType='" + preferredCarType + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", isVerified=" + isVerified +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return Objects.equals(buyerId, buyer.buyerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyerId);
    }

    public static class Builder {
        private String buyerId;
        private String userId;
        private String fullName;
        private String email;
        private String password;
        private String phoneNumber;
        private String preferredCarType;
        private String paymentMethod;
        private boolean isVerified;

        public Builder setBuyerId(String buyerId) {
            this.buyerId = buyerId;
            return this;
        }

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setEmail(String email) {
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

        public Builder setPreferredCarType(String preferredCarType) {
            this.preferredCarType = preferredCarType;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setVerified(boolean verified) {
            this.isVerified = verified;
            return this;
        }

        public Builder copy(Buyer buyer) {
            this.buyerId = buyer.buyerId;
            this.userId = buyer.userId;
            this.fullName = buyer.fullName;
            this.email = buyer.email;
            this.phoneNumber = buyer.phoneNumber;
            this.preferredCarType = buyer.preferredCarType;
            this.paymentMethod = buyer.paymentMethod;
            this.isVerified = buyer.isVerified;
            return this;
        }

        public Buyer build() {
            return new Buyer(this);
        }
    }
}