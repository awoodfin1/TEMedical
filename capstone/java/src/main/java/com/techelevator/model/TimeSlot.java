package com.techelevator.model;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeSlot {

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private int providerId;

    public TimeSlot() { }

    public LocalDate getAppointmentDate() {
        return this.date;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.date = appointmentDate;
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return this.endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getProviderId() {
        return this.providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }
}
