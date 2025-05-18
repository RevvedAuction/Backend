/*
AuctionSession.java
Author: Caitlin Malan
Student Number: 230426271
Date: 23 March 2025
 */

package Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class AuctionSession {

    @Id
    private String sessionID;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;
    private boolean sessionStatus;
    private String carVIN;

    public AuctionSession() {
    }

    private AuctionSession(Builder builder) {
        this.sessionID = builder.sessionID;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.date = builder.date;
        this.sessionStatus = builder.sessionStatus;
        this.carVIN = builder.carVIN;
    }

    public String getSessionID() {
        return sessionID;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isSessionStatus() {
        return sessionStatus;
    }

    public String getCarVIN() {
        return carVIN;
    }

    @Override
    public String toString() {
        return "AuctionSession{" +
                "sessionID='" + sessionID + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", date=" + date +
                ", sessionStatus=" + sessionStatus +
                ", carVIN='" + carVIN + '\'' +
                '}';
    }

    public static class Builder{
        private String sessionID;
        private LocalTime startTime;
        private LocalTime endTime;
        private LocalDate date;
        private boolean sessionStatus;
        private String carVIN;

        public Builder setSessionID(String sessionID) {
            this.sessionID = sessionID;
            return this;
        }

        public Builder setStartTime(LocalTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder setEndTime(LocalTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setSessionStatus(boolean sessionStatus) {
            this.sessionStatus = sessionStatus;
            return this;
        }

        public Builder setCarVIN(String carVIN) {
            this.carVIN = carVIN;
            return this;
        }

        public Builder copy(AuctionSession auctionSession){
            this.sessionID = auctionSession.getSessionID();
            this.startTime = auctionSession.getStartTime();
            this.endTime = auctionSession.getEndTime();
            this.date = auctionSession.getDate();
            this.sessionStatus = auctionSession.isSessionStatus();
            this.carVIN = auctionSession.getCarVIN();
            return this;
        }

        public AuctionSession build(){
            return new AuctionSession(this);
        }
    }
}
