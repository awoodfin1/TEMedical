package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private int id;
    private int patientId;
    private int providerId;
    private LocalDate appointmentDate;
    private LocalTime apptStartTime;
    private LocalTime apptEndTime;
    private String status;            //Appointment is (confirmed, rescheduled, cancelled, completed).
    private String appointmentReason;
    private String appointmentDetails;
    private boolean isNewPatient;

    public Appointment(){
    }

    public Appointment(int patientId, int providerId, LocalDate date, LocalTime apptStartTime, String appointmentReason, String appointmentDetails, boolean isNewPatient) {
        this.patientId = patientId;
        this.providerId = providerId;
        this.appointmentDate = date;
        this.apptStartTime = apptStartTime;
        this.apptEndTime = apptStartTime.plusMinutes(30);
        this.appointmentReason = appointmentReason;
        this.appointmentDetails = appointmentDetails;
        this.isNewPatient = isNewPatient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getApptStartTime() {
        return apptStartTime;
    }

    public void setApptStartTime(LocalTime apptStartTime) {
        this.apptStartTime = apptStartTime;
    }

    public LocalTime getApptEndTime() {
        return apptEndTime;
    }

    public void setApptEndTime(LocalTime apptEndTime) {
        this.apptEndTime = apptEndTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAppointmentReason() {
        return appointmentReason;
    }

    public void setAppointmentReason(String appointmentReason) {
        this.appointmentReason = appointmentReason;
    }

    public String getAppointmentDetails() {
        return appointmentDetails;
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

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", providerId=" + providerId +
                ", appointmentDate=" + appointmentDate +
                ", apptStartTime=" + apptStartTime +
                ", apptEndTime=" + apptEndTime +
                ", status='" + status + '\'' +
                ", appointmentReason='" + appointmentReason + '\'' +
                ", appointmentDetails='" + appointmentDetails + '\'' +
                '}';
    }
}
