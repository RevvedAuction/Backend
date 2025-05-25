package za.co.revvedAuctions.domain;

/*
User.java

User POJO class

Author: L Matthews(221818340)

Date: 11 May 2025

*/

public class Car {

    private String carVIN;
    private String carMake;
    private String carModel;
    private int carYear;
    private int carMileage;
    private String carStatus;
    private String media;

    public Car() {
    }

    private Car(Builder builder) {
        this.carVIN = builder.carVIN;
        this.carMake = builder.carMake;
        this.carModel = builder.carModel;
        this.carYear = builder.carYear;
        this.carMileage = builder.carMileage;
        this.carStatus = builder.carStatus;
        this.media = builder.media;
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

        public Builder copy(Car car) {
            this.carVIN = car.getCarVIN();
            this.carMake = car.getCarMake();
            this.carModel = car.getCarModel();
            this.carYear = car.getCarYear();
            this.carMileage = car.getCarMileage();
            this.carStatus = car.getCarStatus();
            this.media = car.getMedia();
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
