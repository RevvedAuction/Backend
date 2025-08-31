package za.co.revvedAuctions.factory;

import za.co.revvedAuctions.domain.Admin;
import za.co.revvedAuctions.util.Helper;

import java.time.LocalDate;
import java.util.UUID;


public class AdminFactory {
    public static Admin createAdmin(int adminNumber, String fullName, String email, String password, String phoneNumber) {
        if (Helper.isNullOrEmpty(fullName) || Helper.isNullOrEmpty(email) || !Helper.isValidEmail(email) || Helper.isNullOrEmpty(password)) {
            throw new IllegalArgumentException("fullName cannot be null or empty");
        }

        return new Admin.Builder()
                .setAdminNumber(adminNumber)
                .setFullName(fullName)
                .setEmail(email)
                .setPassword(password)
                .setPhoneNumber(phoneNumber)
                .setDateCreated(LocalDate.now())
                .build();
    }
}