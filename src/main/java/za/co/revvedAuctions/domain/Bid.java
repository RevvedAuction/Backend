package za.co.revvedAuctions.domain;

/*Bid
 * Bid.java
 * Bid POJO class
 * Author: Engetelo Mathebane (230227767)
 * Date: 2025-05-11
 */

import java.time.LocalDate;

public class Bid {

    protected int bidId;

    protected String carVIN;

    protected String AuctionSessionId;

    protected String  userId;

    protected double bidAmount;

    protected LocalDate bidDate;

    protected String status;

    protected int totalBids;

    protected  Bid(){
    }

    public Bid(Builder builder) {
        this.bidId = builder.bidId;
        this.carVIN = builder.carVIN;
        this.AuctionSessionId = builder.AuctionSessionId;
        this.userId = builder.userId;
        this.bidAmount = builder.bidAmount;
        this.bidDate = builder.bidDate;
        this.status = builder.status;
        this.totalBids = builder.totalBids;
    }

    public int getBidId() {
        return bidId;
    }

    public String getCarVIN() {
        return carVIN;
    }

    public String getAuctionSessionId() {
        return AuctionSessionId;
    }

    public String getUserId() {
        return userId;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public LocalDate getBidDate() {
        return bidDate;
    }

    public String getStatus() {
        return status;
    }

    public int getTotalBids() {
        return totalBids;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "bidId=" + bidId +
                ", carVIN='" + carVIN + '\'' +
                ", AuctionSessionId='" + AuctionSessionId + '\'' +
                ", userId='" + userId + '\'' +
                ", bidAmount=" + bidAmount +
                ", bidDate=" + bidDate +
                ", status='" + status + '\'' +
                ", totalBids=" + totalBids +
                '}';
    }

    public static class Builder{
        protected int bidId;

        protected String carVIN;

        protected String AuctionSessionId;

        protected String  userId;

        protected double bidAmount;

        protected LocalDate bidDate;

        protected String status;

        protected int totalBids;

        public Builder setBidId(int bidId) {
            this.bidId = bidId;
            return this;
        }

        public Builder setCarVIN(String carVIN) {
            this.carVIN = carVIN;
            return this;
        }

        public Builder setAuctionSessionId(String auctionSessionId) {
            AuctionSessionId = auctionSessionId;
            return this;
        }

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setBidAmount(double bidAmount) {
            this.bidAmount = bidAmount;
            return this;
        }

        public Builder setBidDate(LocalDate bidDate) {
            this.bidDate = bidDate;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setTotalBids(int totalBids) {
            this.totalBids = totalBids;
            return this;
        }

        public Builder copy(Bid bid) {
            this.bidId = bid.bidId;
            this.carVIN = bid.carVIN;
            this.AuctionSessionId = bid.AuctionSessionId;
            this.userId = bid.userId;
            this.bidAmount = bid.bidAmount;
            this.bidDate = bid.bidDate;
            this.status = bid.status;
            this.totalBids = bid.totalBids;
            return this;
        }
        public Bid build() {
            return new Bid(this);
        }
    }
}
