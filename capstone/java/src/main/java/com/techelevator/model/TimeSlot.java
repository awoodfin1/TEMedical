package com.techelevator.model;

import java.sql.Date;
import java.sql.Time;

public class TimeSlot {

    private Date date;
    private Time startTime;
    private Time endTime;
    private int providerId;

    public TimeSlot() { }

    public Date getAppointmentDate() {
        return this.date;
    }

    public void setAppointmentDate(Date appointmentDate) {
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
