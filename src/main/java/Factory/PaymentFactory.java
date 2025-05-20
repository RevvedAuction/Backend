package Factory;

/* Author: Makungo FM (KodeKnack)
   Student NO: 230787932
*/
import Domain.Payment;
import Util.Helper;

public class PaymentFactory {
    public static Payment createPayment(
            int paymentID,
            double amount,
            String paymentMethod,
            String status,
            int buyerID,
            int auctionID) {

        if (Helper.isNullOrEmpty(paymentID)
                || Helper.isNullOrEmpty(amount)
                || Helper.isNullOrEmpty(paymentMethod)
                || Helper.isNullOrEmpty(status)
                || Helper.isNullOrEmpty(buyerID)
                || Helper.isNullOrEmpty(auctionID)) {
            return null;
        }

        return new Payment.Builder()
                .setPaymentID(paymentID)
                .setAmount(amount)
                .setPaymentMethod(paymentMethod)
                .setStatus(status)
                .setBuyerID(buyerID)
                .setAuctionID(auctionID)
                .build();

    }
}