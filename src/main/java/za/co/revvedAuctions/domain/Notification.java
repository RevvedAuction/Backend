package za.co.revvedAuctions.domain;

/*
Author: Fhumulani Moses Makungo (230787932)
alias: KodeKnack

*
*/

import java.time.LocalDateTime;

public class Notification {
    protected int notificationID;
    protected String notificationType;
    protected String message;
    protected LocalDateTime dateTime;
    protected boolean isRead;



    public Notification() {
    }

    public Notification(Builder builder) {
        this.notificationID = builder.notificationID;
        this.notificationType = builder.notificationType;
        this.message = builder.message;
        this.dateTime = builder.dateTime;
        this.isRead = builder.isRead;
    }

    public int getNotificationID() {
        return notificationID;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public boolean isRead() {
        return isRead;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationID=" + notificationID +
                ", notificationType='" + notificationType + '\'' +
                ", message='" + message + '\'' +
                ", dateTime=" + dateTime +
                ", isRead=" + isRead +
                '}';
    }

    public static class Builder {
        private int notificationID;
        private String notificationType;
        private String message;
        private LocalDateTime dateTime;
        private boolean isRead;

        public Builder setNotificationID(int notificationID) {
            this.notificationID = notificationID;
            return this;
        }

        public Builder setNotificationType(String notificationType) {
            this.notificationType = notificationType;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Builder setRead(boolean isRead) {
            this.isRead = isRead;
            return this;
        }

        public Builder copy(Notification notification) {
            this.notificationID = notification.notificationID;
            this.notificationType = notification.notificationType;
            this.message = notification.message;
            this.dateTime = notification.dateTime;
            this.isRead = notification.isRead;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }
}
