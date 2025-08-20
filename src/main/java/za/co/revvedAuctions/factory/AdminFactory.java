package za.co.revvedAuctions.factory;

import za.co.revvedAuctions.domain.Admin;
import za.co.revvedAuctions.util.Helper;

import java.time.LocalDate;
import java.util.UUID;


public class AdminFactory {
    public static Admin createAdmin(
            String fullName,
            String email,
            String password,
            String phoneNumber,
            String role,
            boolean isActive
    ) {
        if (Helper.isNullOrEmpty(fullName)) {
            throw new IllegalArgumentException("fullName cannot be null or empty");
        }
        if (Helper.isNullOrEmpty(email)) {
            throw new IllegalArgumentException("email cannot be null or empty");
        }
        if (!Helper.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format: " + email);
        }
        if (Helper.isNullOrEmpty(password)) {
            throw new IllegalArgumentException("password cannot be null or empty");
        }

        String adminId = UUID.randomUUID().toString();

        return new Admin.Builder()
                .setAdminId(adminId)
                .setFullName(fullName)
                .setEmail(email)
                .setPassword(password)
                .setPhoneNumber(phoneNumber)
                .setRole(role)
                .setActive(isActive)
                .setDateCreated(LocalDate.now())
                .build();
    }
}