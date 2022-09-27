package com.techelevator.dao;

import com.techelevator.model.Appointment;

import java.util.List;

public interface AppointmentDao {

    // create

    // read
    List<Appointment> getAllAppointments();

    Appointment getApptById();

    Appointment getApptByProviderId();

    Appointment getApptByDate();
    
    // update

    // delete
}
