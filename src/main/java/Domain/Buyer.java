package Domain;

/* Buyer.java
   Buyer Entity Class using Builder Pattern
   Author: Zintle Mgqongose 214280829
   Date: 11 May 2025
*/


public class Buyer {
    private String buyerId;
    private String userId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String preferredCarType;
    private String paymentMethod;
    private boolean isVerified;

    protected Buyer() {
    }

    protected Buyer(Builder builder) {
        this.buyerId = builder.buyerId;
        this.userId = builder.userId;
        this.fullName = builder.fullName;
        this.email = builder.email;
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
                ", phoneNumber='" + phoneNumber + '\'' +
                ", preferredCarType='" + preferredCarType + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", isVerified=" + isVerified +
                '}';
    }

    public static class Builder {
        private String buyerId;
        private String userId;
        private String fullName;
        private String email;
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
            isVerified = verified;
            return this;
        }

        public Builder copy(Buyer buyer){
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
