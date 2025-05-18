package Factory;

/*
Company.java
Author: Esihle Mlinjana
Student Number: 222441712
Date: 18 May 2025
 */

import Domain.Individual;
import Util.Helper;

public class IndividualFactory {

    public static Individual createIndividual(int individualId, String firstName, String lastName, String emailAddress, String phoneNumber) {
        if (Helper.isNullOrEmpty(individualId) || Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(emailAddress) || Helper.isNullOrEmpty(phoneNumber)) {
            return null;
        }
        return new Individual.Builder()
                .setIndividualId(individualId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmailAddress(emailAddress)
                .setPhoneNumber(phoneNumber)
                .build();
    }
}
