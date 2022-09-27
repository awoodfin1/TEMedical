package com.techelevator.model;

import java.sql.Time;
import java.time.LocalDate;

public class Appointment {

    private int id;
    private int patientId;
    private int providerId;
    private LocalDate appointmentDate;
    private Time apptStartTime;
    private Time apptEndTime;
    private String status;            //Appointment is (confirmed, rescheduled, cancelled, completed).
    private String appointmentReason;
    private String appointmentDetails;

    public Appointment(){
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

    public Time getApptStartTime() {
        return apptStartTime;
    }

    public void setApptStartTime(Time apptStartTime) {
        this.apptStartTime = apptStartTime;
    }

    public Time getApptEndTime() {
        return apptEndTime;
    }

    public void setApptEndTime(Time apptEndTime) {
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

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", providerId=" + providerId +
                ", appointmentDate=" + appointmentDate +
                ", apptStartTime=" + apptStartTime +
                ", apptEndTime=" + apptEndTime +
                ", status=" + status +
                ", appointmentReason='" + appointmentReason + '\'' +
                ", appointmentDetails='" + appointmentDetails + '\'' +
                '}';
    }
}
