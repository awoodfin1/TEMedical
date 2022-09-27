package com.techelevator.dao;

import com.techelevator.model.Appointment;

import java.util.List;

public interface AppointmentDao {

    // create
    boolean createAppointment();

    // read
    List<Appointment> getAllAppointments();

    Appointment getApptById();

    List<Appointment> getAllApptsByDate();
    
    // update


    // delete
}
