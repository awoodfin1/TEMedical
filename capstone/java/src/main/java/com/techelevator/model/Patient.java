package com.techelevator.model;

import java.time.LocalDate;

public class Patient {

    private int id;
    private int userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private LocalDate birthdate;
    private String healthIssuesDescription;
    private boolean displayApptUpdate;

    public Patient() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getHealthIssuesDescription() {
        return this.healthIssuesDescription;
    }

    public void setHealthIssuesDescription(String healthIssuesDescription) {
        this.healthIssuesDescription = healthIssuesDescription;
    }

    public boolean isDisplayApptUpdate() {
        return this.displayApptUpdate;
    }

    public void setDisplayApptUpdate(boolean displayApptUpdate) {
        this.displayApptUpdate = displayApptUpdate;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
