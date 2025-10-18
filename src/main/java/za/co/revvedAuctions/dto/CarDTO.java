package za.co.revvedAuctions.dto;

import java.time.LocalDateTime;

public class CarDTO {
    private String carVIN;
    private String carMake;
    private String carModel;
    private int carYear;
    private int carMileage;
    private String carStatus;
    private String mediaBase64;
    private LocalDateTime auctionEndTime;
    private Double currentBid;

    public String getCarVIN() { return carVIN; }
    public void setCarVIN(String carVIN) { this.carVIN = carVIN; }
    public String getCarMake() { return carMake; }
    public void setCarMake(String carMake) { this.carMake = carMake; }
    public String getCarModel() { return carModel; }
    public void setCarModel(String carModel) { this.carModel = carModel; }
    public int getCarYear() { return carYear; }
    public void setCarYear(int carYear) { this.carYear = carYear; }
    public int getCarMileage() { return carMileage; }
    public void setCarMileage(int carMileage) { this.carMileage = carMileage; }
    public String getCarStatus() { return carStatus; }
    public void setCarStatus(String carStatus) { this.carStatus = carStatus; }
    public String getMediaBase64() { return mediaBase64; }
    public void setMediaBase64(String mediaBase64) { this.mediaBase64 = mediaBase64; }
    public LocalDateTime getAuctionEndTime() { return auctionEndTime; }
    public void setAuctionEndTime(LocalDateTime auctionEndTime) { this.auctionEndTime = auctionEndTime; }
    public Double getCurrentBid() { return currentBid; }
    public void setCurrentBid(Double currentBid) { this.currentBid = currentBid; }
}
