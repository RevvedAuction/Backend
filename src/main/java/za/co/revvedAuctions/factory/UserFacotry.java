package za.co.revvedAuctions.factory;

import za.co.revvedAuctions.domain.User;
import za.co.revvedAuctions.util.Helper;

public class UserFacotry {

    public static User createUser(String userID, String userType ,String Name,
                                  String password , boolean sessionStatus , String carVin) {

        if (Helper.isNullOrEmpty(userID) || Helper.isNullOrEmpty(userType) || Helper.isNullOrEmpty(Name) || Helper.isNullOrEmpty(password)
                || Helper.isNullOrEmpty(sessionStatus) || Helper.isNullOrEmpty(carVin) ) {
        return null;

        }
        return new User.Builder().setUserID(userID).setUserPassword(password).setUserType(userType).setUserName(Name)
                .setSessionStatus(sessionStatus)
                .setCarVIN(carVin).build();
    }
}
