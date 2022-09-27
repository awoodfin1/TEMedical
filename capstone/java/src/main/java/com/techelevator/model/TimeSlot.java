package com.techelevator.model;

import org.apache.tomcat.jni.Local;

import java.sql.Time;
import java.time.LocalDate;

public class TimeSlot {

    private LocalDate date;
    private Time startTime;
    private Time endTime;
    private int providerId;

    public TimeSlot() { }

    public LocalDate getAppointmentDate() {
        return this.date;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.date = appointmentDate;
    }

    public Time getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public int getProviderId() {
        return this.providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }
}
