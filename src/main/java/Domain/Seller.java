/*
Seller.java
Author: Caitlin Malan
Student Number: 230426271
Date: 23 March 2025
 */

package Domain;

public class Seller {

    private String sellerId;
    private String businessType;

    public Seller() {
    }

    private Seller(Builder builder) {}

    public String getSellerId() {
        return sellerId;
    }

    public String getBusinessType() {
        return businessType;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerId='" + sellerId + '\'' +
                ", businessType='" + businessType + '\'' +
                '}';
    }

    public static class Builder {
        private String sellerId;
        private String businessType;

        public Builder setSellerId(String sellerId) {
            this.sellerId = sellerId;
            return this;
        }

        public Builder setBusinessType(String businessType) {
            this.businessType = businessType;
            return this;
        }

        public Builder copy(Seller seller) {
            this.sellerId = seller.getSellerId();
            this.businessType = seller.getBusinessType();
            return this;
        }

        public Seller build(){
            return new Seller(this);
        }
    }
}
