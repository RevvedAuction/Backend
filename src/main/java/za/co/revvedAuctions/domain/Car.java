package za.co.revvedAuctions.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Car entity for auctions
 * Author: L Matthews (221818340) | Updated by Esihle
 * Date: 11 May 2025
 */
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "car_vin", nullable = false, unique = true)
    private String carVIN;

    @Column(nullable = false)
    private String carMake;

    @Column(nullable = false)
    private String carModel;

    private int carYear;

    private int carMileage;

    @Column(nullable = false)
    private String carStatus;

    @Column(length = 1000)
    private String media;

    @Column(nullable = false)
    private LocalDateTime auctionEndTime;

    protected Car() {}

    private Car(Builder builder) {
        this.carVIN = builder.carVIN;
        this.carMake = builder.carMake;
        this.carModel = builder.carModel;
        this.carYear = builder.carYear;
        this.carMileage = builder.carMileage;
        this.carStatus = builder.carStatus;
        this.media = builder.media;
        this.auctionEndTime = builder.auctionEndTime;
    }

    public String getCarVIN() {
        return carVIN;
    }

    public String getCarMake() {
        return carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getCarYear() {
        return carYear;
    }

    public int getCarMileage() {
        return carMileage;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public String getMedia() {
        return media;
    }

    public LocalDateTime getAuctionEndTime() {
        return auctionEndTime;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carVIN='" + carVIN + '\'' +
                ", carMake='" + carMake + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carYear=" + carYear +
                ", carMileage=" + carMileage +
                ", carStatus='" + carStatus + '\'' +
                ", media='" + media + '\'' +
                ", auctionEndTime=" + auctionEndTime +
                '}';
    }

    public static class Builder {
        private String carVIN;
        private String carMake;
        private String carModel;
        private int carYear;
        private int carMileage;
        private String carStatus;
        private String media;
        private LocalDateTime auctionEndTime;

        public Builder setCarVIN(String carVIN) {
            this.carVIN = carVIN;
            return this;
        }

        public Builder setCarMake(String carMake) {
            this.carMake = carMake;
            return this;
        }

        public Builder setCarModel(String carModel) {
            this.carModel = carModel;
            return this;
        }

        public Builder setCarYear(int carYear) {
            this.carYear = carYear;
            return this;
        }

        public Builder setCarMileage(int carMileage) {
            this.carMileage = carMileage;
            return this;
        }

        public Builder setCarStatus(String carStatus) {
            this.carStatus = carStatus;
            return this;
        }

        public Builder setMedia(String media) {
            this.media = media;
            return this;
        }

        public Builder setAuctionEndTime(LocalDateTime auctionEndTime) {
            this.auctionEndTime = auctionEndTime;
            return this;
        }

        public Builder copy(Car car) {
            this.carVIN = car.getCarVIN();
            this.carMake = car.getCarMake();
            this.carModel = car.getCarModel();
            this.carYear = car.getCarYear();
            this.carMileage = car.getCarMileage();
            this.carStatus = car.getCarStatus();
            this.media = car.getMedia();
            this.auctionEndTime = car.getAuctionEndTime();
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
