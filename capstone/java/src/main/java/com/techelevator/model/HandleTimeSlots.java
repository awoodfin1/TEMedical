package com.techelevator.model;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HandleTimeSlots {

    private LocalDate date;
    private int providerId;
    private Time slotDuration;
    List<Appointment> allApptsByDate = new ArrayList<>();

//    public HandleTimeslots() {
//        this.slotDuration =
//    }

    public List<TimeSlot> createTimeSlotsList(LocalDate date, int providerId,Time slotDuration) {
        List<TimeSlot> timeSlotsList = new ArrayList<>();
        setDate(date);
        setSlotDuration(slotDuration);

        return null;
    }

    private void setDate(LocalDate date) {
        this.date = date;
    }

    private void setSlotDuration(Time slotDuration) {
        this.slotDuration = slotDuration;
    }

}
