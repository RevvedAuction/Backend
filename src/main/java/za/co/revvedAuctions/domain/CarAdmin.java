package za.co.revvedAuctions.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "caradmin")
public class CarAdmin{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID carId;

    private String make;
    private String model;
    private int year;
    private double price;
    private String description;
    private String imageUrl; // optional URL/path to car image
    private LocalDate dateCreated;

    // Default constructor for JPA
    protected CarAdmin() {
    }

    // Builder constructor
    protected CarAdmin(Builder builder) {
        this.make = builder.make;
        this.model = builder.model;
        this.year = builder.year;
        this.price = builder.price;
        this.description = builder.description;
        this.imageUrl = builder.imageUrl;
        this.dateCreated = builder.dateCreated;
    }

    // Getters
    public UUID getCarId() { return carId; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public String getImageUrl() { return imageUrl; }
    public LocalDate getDateCreated() { return dateCreated; }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }

    // Builder class
    public static class Builder {
        private String make;
        private String model;
        private int year;
        private double price;
        private String description;
        private String imageUrl;
        private LocalDate dateCreated;

        public Builder setMake(String make) {
            this.make = make;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder setDateCreated(LocalDate dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public Builder copy(CarAdmin carAdmin) {
            this.make = carAdmin.make;
            this.model = carAdmin.model;
            this.year = carAdmin.year;
            this.price = carAdmin.price;
            this.description = carAdmin.description;
            this.imageUrl = carAdmin.imageUrl;
            this.dateCreated = carAdmin.dateCreated;
            return this;
        }

        public CarAdmin build() {
            return new CarAdmin(this);
        }
    }
}
