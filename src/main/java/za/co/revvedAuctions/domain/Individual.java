/*
Individual.java
Author: Liam Matthews
Student Number: 221818340
Date: 28 August 2025
*/
package za.co.revvedAuctions.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "individuals")
public class Individual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int individualId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String emailAddress;

    private LocalDate dateOfBirth;

    @Column(unique = true)
    private String identityNumber;

    private String phoneNumber;

    private String homeAddress;

    protected Individual() {} // JPA requires protected or default constructor

    private Individual(Builder builder) {
        this.individualId = builder.individualId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.emailAddress = builder.emailAddress;
        this.dateOfBirth = builder.dateOfBirth;
        this.identityNumber = builder.identityNumber;
        this.phoneNumber = builder.phoneNumber;
        this.homeAddress = builder.homeAddress;
    }

    // Getters
    public int getIndividualId() { return individualId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmailAddress() { return emailAddress; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public String getIdentityNumber() { return identityNumber; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getHomeAddress() { return homeAddress; }

    @Override
    public String toString() {
        return "Individual{" +
                "individualId=" + individualId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", identityNumber='" + identityNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                '}';
    }

    // Builder class
    public static class Builder {
        private int individualId;
        private String firstName;
        private String lastName;
        private String emailAddress;
        private LocalDate dateOfBirth;
        private String identityNumber;
        private String phoneNumber;
        private String homeAddress;

        public Builder setIndividualId(int individualId) { this.individualId = individualId; return this; }
        public Builder setFirstName(String firstName) { this.firstName = firstName; return this; }
        public Builder setLastName(String lastName) { this.lastName = lastName; return this; }
        public Builder setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; return this; }
        public Builder setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; return this; }
        public Builder setIdentityNumber(String identityNumber) { this.identityNumber = identityNumber; return this; }
        public Builder setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; return this; }
        public Builder setHomeAddress(String homeAddress) { this.homeAddress = homeAddress; return this; }

        public Builder copy(Individual individual) {
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

        public Individual build() { return new Individual(this); }
    }
}
