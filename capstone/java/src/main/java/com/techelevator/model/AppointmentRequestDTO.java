package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentRequestDTO {
    private LocalDate date;
    private LocalTime startTime;

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
}
