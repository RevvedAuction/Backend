package za.co.revvedAuctions.domain;
/*AuctionHistory
 * AuctionHistrory.java
 *  AuctionHistory POJO class
 * Author: Engetelo Mathebane (230227767)
 * Date: 2025-05-11
 */
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class AuctionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected 

    protected String auctionSessionId;

    protected String carVIN;

    protected String userId;

    protected String sellerId;

    protected String  buyerId;

    protected double finalPrice;

    protected LocalDate auctionDate;

    protected String status;

    protected AuctionHistory() {
    }

    public AuctionHistory(Builder builder) {
        this.historyId = builder.historyId;
        this.auctionSessionId = builder.auctionSessionId;
        this.carVIN = builder.carVIN;
        this.userId = builder.userId;
        this.sellerId = builder.sellerId;
        this.buyerId = builder.buyerId;
        this.finalPrice = builder.finalPrice;
        this.auctionDate = builder.auctionDate;
        this.status = builder.status;
    }

    public int getHistoryId() {
        return historyId;
    }

    public String getAuctionSessionId() {
        return auctionSessionId;
    }

    public String getCarVIN() {
        return carVIN;
    }

    public String getUserId() {
        return userId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public LocalDate getAuctionDate() {
        return auctionDate;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "AuctionHistory{" +
                "historyId=" + historyId +
                ", auctionSessionId='" + auctionSessionId + '\'' +
                ", carVIN='" + carVIN + '\'' +
                ", userId='" + userId + '\'' +
                ", sellerId='" + sellerId + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", finalPrice=" + finalPrice +
                ", auctionDate=" + auctionDate +
                ", status='" + status + '\'' +
                '}';
    }
    public static class Builder {
        protected int historyId;
        protected String auctionSessionId;
        protected String carVIN;
        protected String userId;
        protected String sellerId;
        protected String buyerId;
        protected double finalPrice;
        protected LocalDate auctionDate;
        protected String status;

        public Builder setHistoryId(int historyId) {
            this.historyId = historyId;
            return this;
        }

        public Builder setAuctionSessionId(String auctionSessionId) {
            this.auctionSessionId = auctionSessionId;
            return this;
        }

        public Builder setCarVIN(String carVIN) {
            this.carVIN = carVIN;
            return this;
        }

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setSellerId(String sellerId) {
            this.sellerId = sellerId;
            return this;
        }

        public Builder setBuyerId(String buyerId) {
            this.buyerId = buyerId;
            return this;
        }

        public Builder setFinalPrice(double finalPrice) {
            this.finalPrice = finalPrice;
            return this;
        }

        public Builder setAuctionDate(LocalDate auctionDate) {
            this.auctionDate = auctionDate;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

       public Builder copy(AuctionHistory auctionHistory) {
            this.historyId = auctionHistory.getHistoryId();
            this.auctionSessionId = auctionHistory.getAuctionSessionId();
            this.carVIN = auctionHistory.getCarVIN();
            this.userId = auctionHistory.getUserId();
            this.sellerId = auctionHistory.getSellerId();
            this.buyerId = auctionHistory.getBuyerId();
            this.finalPrice = auctionHistory.getFinalPrice();
            this.auctionDate = auctionHistory.getAuctionDate();
            this.status = auctionHistory.getStatus();
            return this;
        }

        public AuctionHistory build() {
            return new AuctionHistory(this);
        }

    }
}
