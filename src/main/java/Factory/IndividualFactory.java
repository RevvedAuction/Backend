package Factory;

/*
Company.java
Author: Esihle Mlinjana
Student Number: 222441712
Date: 18 May 2025
 */

import Domain.Individual;
import Util.Helper;

import java.time.LocalDate;

public class IndividualFactory {

    public static Individual createIndividual(int individualId, String firstName, String lastName, String emailAddress, String phoneNumber) {
        if (Helper.isNullOrEmpty(individualId) || Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || !Helper.isValidEmail(emailAddress) || Helper.isNullOrEmpty(phoneNumber)) {
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

    public static Individual createIndividual(int individualId, String firstName, String lastName, String emailAddress, LocalDate dateOfBirth, int identityNumber, String phoneNumber, String homeAddress) {
        if (Helper.isNullOrEmpty(individualId) || Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || !Helper.isValidEmail(emailAddress) || Helper.isNullOrEmpty(dateOfBirth) || Helper.isNullOrEmpty(identityNumber) || Helper.isNullOrEmpty(phoneNumber) || Helper.isNullOrEmpty(homeAddress)) {
            return null;
        }
        return new Individual.Builder()
                .setIndividualId(individualId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmailAddress(emailAddress)
                .setDateOfBirth(dateOfBirth)
                .setIdentityNumber(identityNumber)
                .setPhoneNumber(phoneNumber)
                .setHomeAddress(homeAddress)
                .build();
    }
}
