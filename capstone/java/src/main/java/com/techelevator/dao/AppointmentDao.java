package com.techelevator.dao;

import com.techelevator.model.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentDao {

    // create
    Appointment createAppointment(Appointment newAppointment);

    // read
    List<Appointment> getAllAppointments();

    Appointment getApptById(int apptId);

    List<Appointment> getAllApptsByPatientId(int patientId);

    List<Appointment> getAllApptsByProviderId(int providerId);

    List<Appointment> getAllApptsByDateByPatientId(LocalDate date, int patientId);

    List<Appointment> getAllApptsByProviderIdByDate(int providerId, LocalDate date);

    List<LocalTime> getApptStartTimes(int providerId, LocalDate date);

    List<LocalTime> getAvailability(int providerId, LocalDate date); // take list of start times & compare

    // update

    void updateAppointment(Appointment appointment);

    // delete
}
