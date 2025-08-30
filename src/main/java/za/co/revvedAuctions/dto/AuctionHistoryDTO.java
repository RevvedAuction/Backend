package za.co.revvedAuctions.dto;

import java.time.LocalDate;

public class AuctionHistoryDTO {
    private int historyId;
    private String auctionSessionId;
    private String carVIN;
    private String userId;
    private String sellerId;
    private String buyerId;
    private double finalPrice;
    private LocalDate auctionDate;
    private String status;

    // Getters & Setters
    public int getHistoryId() { return historyId; }
    public void setHistoryId(int historyId) { this.historyId = historyId; }
    public String getAuctionSessionId() { return auctionSessionId; }
    public void setAuctionSessionId(String auctionSessionId) { this.auctionSessionId = auctionSessionId; }
    public String getCarVIN() { return carVIN; }
    public void setCarVIN(String carVIN) { this.carVIN = carVIN; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getSellerId() { return sellerId; }
    public void setSellerId(String sellerId) { this.sellerId = sellerId; }
    public String getBuyerId() { return buyerId; }
    public void setBuyerId(String buyerId) { this.buyerId = buyerId; }
    public double getFinalPrice() { return finalPrice; }
    public void setFinalPrice(double finalPrice) { this.finalPrice = finalPrice; }
    public LocalDate getAuctionDate() { return auctionDate; }
    public void setAuctionDate(LocalDate auctionDate) { this.auctionDate = auctionDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
