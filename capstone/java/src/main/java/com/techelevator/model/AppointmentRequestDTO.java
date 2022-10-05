package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentRequestDTO {
    private LocalDate date;
    private LocalTime startTime;
    private String appointmentReason;
    private String appointmentDetails;
    private boolean isNewPatient;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public String getAppointmentReason() {
        return this.appointmentReason;
    }

    public void setAppointmentReason(String appointmentReason) {
        this.appointmentReason = appointmentReason;
    }

    public String getAppointmentDetails() {
        return this.appointmentDetails;
    }

    public void setAppointmentDetails(String appointmentDetails) {
        this.appointmentDetails = appointmentDetails;
    }

    public boolean isNewPatient() {
        return this.isNewPatient;
    }

    public void setNewPatient(boolean newPatient) {
        isNewPatient = newPatient;
    }
}
