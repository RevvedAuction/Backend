package za.co.revvedAuctions.factory;

import za.co.revvedAuctions.domain.Buyer;
import za.co.revvedAuctions.util.Helper;

import java.util.UUID;

public class BuyerFactory {

    public static Buyer createBuyer(
            String userId,
            String fullName,
            String email,
            String password,
            String phoneNumber,
            String preferredCarType,
            String paymentMethod,
            boolean isVerified
    ) {
        if (Helper.isNullOrEmpty(userId)) {
            throw new IllegalArgumentException("userId cannot be null or empty");
        }
        if (Helper.isNullOrEmpty(fullName)) {
            throw new IllegalArgumentException("fullName cannot be null or empty");
        }
        if (Helper.isNullOrEmpty(email)) {
            throw new IllegalArgumentException("email cannot be null or empty");
        }
        if (Helper.isNullOrEmpty(password)) {
            throw new IllegalArgumentException("password cannot be null or empty");
        }
        if (!Helper.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format: " + email);
        }
        if (Helper.isNullOrEmpty(paymentMethod)) {
            throw new IllegalArgumentException("paymentMethod cannot be null or empty");
        }

        String buyerId = UUID.randomUUID().toString();

        return new Buyer.Builder()
                .setBuyerId(buyerId)
                .setUserId(userId)
                .setFullName(fullName)
                .setEmail(email)
                .setPassword(password)
                .setPhoneNumber(phoneNumber)
                .setPreferredCarType(preferredCarType)
                .setPaymentMethod(paymentMethod)
                .setVerified(isVerified)
                .build();
    }
}
