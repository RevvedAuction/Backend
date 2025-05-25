/*
Individual.java
Author: Esihle Mlinjana
Student Number: 222441712
Date: 11 May 2025
 */
package za.co.revvedAuctions.domain;

import java.time.LocalDate;

public class Individual {

    private int individualId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private LocalDate dateOfBirth;
    private int identityNumber;
    private String phoneNumber;
    private String homeAddress;

    public Individual() {
    }

    public Individual(Builder builder) {
        this.individualId = builder.individualId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.emailAddress = builder.emailAddress;
        this.dateOfBirth = builder.dateOfBirth;
        this.identityNumber = builder.identityNumber;
        this.phoneNumber = builder.phoneNumber;
        this.homeAddress = builder.homeAddress;
    }

    public int getIndividualId() {
        return individualId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getIdentityNumber() {
        return identityNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    @Override
    public String toString() {
        return "Individual{" +
                "individualId=" + individualId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", identityNumber=" + identityNumber +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                '}';
    }

    public static class Builder {
        private int individualId;
        private String firstName;
        private String lastName;
        private String emailAddress;
        private LocalDate dateOfBirth;
        private int identityNumber;
        private String phoneNumber;
        private String homeAddress;

        public Builder setIndividualId(int individualId) {
            this.individualId = individualId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setIdentityNumber(int identityNumber) {
            this.identityNumber = identityNumber;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setHomeAddress(String homeAddress) {
            this.homeAddress = homeAddress;
            return this;
        }

        public Builder copy(Individual individual){
            this.individualId = individual.individualId;
            this.firstName = individual.firstName;
            this.lastName = individual.lastName;
            this.emailAddress = individual.emailAddress;
            this.dateOfBirth = individual.dateOfBirth;
            this.identityNumber = individual.identityNumber;
            this.phoneNumber = individual.phoneNumber;
            this.homeAddress = individual.homeAddress;
            return this;
        }
        public Individual build(){
            return new Individual(this);
        }
    }
}
