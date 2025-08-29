package za.co.revvedAuctions.factory;

import za.co.revvedAuctions.domain.User;
import za.co.revvedAuctions.util.Helper;

import java.util.Random;

public class UserFactory{

    public static User createUser(Long userID,
                                  String userType ,
                                  String userFullName,
                                  String userEmail,
                                  String userPassword) {

        userID = new Random().nextLong();

        if (Helper.isNullOrEmpty(userType) ||
                Helper.isNullOrEmpty(userFullName) ||
                Helper.isNullOrEmpty(userEmail) ||
                Helper.isNullOrEmpty(userPassword)) {
            System.out.println("Error: Missing Information");

        }

        if (!Helper.isValidEmail(userEmail)) {
            System.out.println("Invalid email address");
        }
        return new User.Builder()
                .setUserID(userID)
                .setUserType(userType)
                .setUserFullName(userFullName)
                .setUserEmail(userEmail)
                .setUserPassword(userPassword)
//                .setSessionStatus(sessionStatus)
//                .setCarVIN(carVin)
                .build();
    }
}
