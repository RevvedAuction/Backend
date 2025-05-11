package Domain;

import java.time.LocalDate;

public class Payment {
    protected int paymentID;
    double amount;
    String paymentMethod;
    LocalDate paymentDate;
    String status;
    int buyerID;
    int auctionID;
    boolean isRefunded;
    boolean processPay;

    public Payment(){}

    public Payment (Builder builder) {
        this.paymentID = builder.paymentID;
        this.amount = builder.amount;
        this.paymentMethod = builder.paymentMethod;
        this.paymentDate = builder.paymentDate;
        this.status = builder.status;
        this.buyerID = builder.buyerID;
        this.auctionID = builder.auctionID;
        this.isRefunded = builder.isRefunded;
        this.processPay = builder.processPay;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getStatus() {
        return status;
    }

    public int getBuyerID() {
        return buyerID;
    }

    public int getAuctionID() {
        return auctionID;
    }

    public boolean isRefunded() {
        return isRefunded;
    }

    public boolean isProcessPay() {
        return processPay;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID=" + paymentID +
                ", amount=" + amount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentDate=" + paymentDate +
                ", status='" + status + '\'' +
                ", buyerID=" + buyerID +
                ", auctionID=" + auctionID +
                ", isRefunded=" + isRefunded +
                ", processPay=" + processPay +
                '}';
    }

    public static class Builder {
        private int paymentID;
        double amount;
        String paymentMethod;
        LocalDate paymentDate;
        String status;
        int buyerID;
        int auctionID;
        boolean isRefunded;
        boolean processPay;

        public Builder setPaymentID(int paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setPaymentDate(LocalDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setBuyerID(int buyerID) {
            this.buyerID = buyerID;
            return this;
        }

        public Builder setAuctionID(int auctionID) {
            this.auctionID = auctionID;
            return this;
        }

        public Builder setRefunded(boolean isRefunded) {
            this.isRefunded = isRefunded;
            return this;
        }

        public Builder setProcessPay(boolean processPay) {
            this.processPay = processPay;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }


    }



}
