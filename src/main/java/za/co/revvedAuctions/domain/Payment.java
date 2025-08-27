package za.co.revvedAuctions.domain;
/*
Author: Fhumulani Moses Makungo (230787932)
alias: KodeKnack
 */
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentID;

    @Column(nullable = false)
    private double amount;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    @Column(nullable = false)
    private String status;

    @Column(name = "buyer_id", nullable = false)
    private int buyerID;

    @Column(name = "auction_id", nullable = false)
    private int auctionID;

    @Column(name = "is_refunded")
    private boolean isRefunded;

    @Column(name = "process_pay")
    private boolean processPay;

    protected Payment() {}

    private Payment(Builder builder) {
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

    public void setStatus(String status) {
        this.status = status;
    }

    public void setProcessPay(boolean processPay) {
        this.processPay = processPay;
    }

    public void setRefunded(boolean refunded) {
        this.isRefunded = refunded;
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
        private double amount;
        private String paymentMethod;
        private LocalDate paymentDate;
        private String status;
        private int buyerID;
        private int auctionID;
        private boolean isRefunded;
        private boolean processPay;

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

        public Builder copy(Payment payment) {
            this.paymentID = payment.getPaymentID();
            this.amount = payment.getAmount();
            this.paymentMethod = payment.getPaymentMethod();
            this.paymentDate = payment.getPaymentDate();
            this.status = payment.getStatus();
            this.buyerID = payment.getBuyerID();
            this.auctionID = payment.getAuctionID();
            this.isRefunded = payment.isRefunded();
            this.processPay = payment.isProcessPay();
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }


    }



}
