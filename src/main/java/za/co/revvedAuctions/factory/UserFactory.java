package za.co.revvedAuctions.factory;

import za.co.revvedAuctions.domain.User;
import za.co.revvedAuctions.util.Helper;

public class UserFactory {

    public static User createUser(Long userID,
                                  String userType ,
                                  String userFullName,
                                  String userEmail,
                                  String userPassword) {

        if (Helper.isNullOrEmpty(userID) ||
                Helper.isNullOrEmpty(userType) ||
                Helper.isNullOrEmpty(userFullName) ||
                Helper.isNullOrEmpty(userPassword)) {
        return null;

        }

        if (!Helper.isValidEmail(userEmail))
            return null;

        return new User.Builder()
                .setUserID(userID)
                .setUserPassword(userPassword)
                .setUserEmail(userEmail)
                .setUserType(userType)
                .setUserFullName(userFullName)
                .build();
    }
}
