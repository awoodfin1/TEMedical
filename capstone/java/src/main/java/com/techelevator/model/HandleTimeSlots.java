package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class HandleTimeSlots {

    private LocalDate date;
    private int providerId;
    private LocalTime officeOpenTime;
    private LocalTime officeCloseTime;
    private int slotDurationMins;
    List<Appointment> allApptsByDate = new ArrayList<>();

    public HandleTimeSlots() {
        this.slotDurationMins = 30;
    }

    public List<TimeSlot> createTimeSlotsList(LocalDate date, int providerId, int slotDurationMins) {
        List<TimeSlot> timeSlotsList = new ArrayList<>();
        setDate(date);
        setSlotDuration(slotDurationMins);

        return null;
    }

    private void setDate(LocalDate date) {
        this.date = date;
    }

    private void setSlotDuration(int slotDurationMins) {
        this.slotDurationMins = slotDurationMins;
    }

}
