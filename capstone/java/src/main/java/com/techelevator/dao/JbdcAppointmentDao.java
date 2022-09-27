package com.techelevator.dao;

import com.techelevator.model.Appointment;
import com.techelevator.model.HandleTimeSlots;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class JbdcAppointmentDao implements AppointmentDao {

    private JdbcTemplate jdbcTemplate;

    public JbdcAppointmentDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public boolean createAppointment() {
        return false;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        List<Appointment> allAppts = new ArrayList<>();
        String sql = "SELECT appointment_id, patient_id, provider_id, appointment_date, appt_start_time, appt_end_time, status, appointment_reason, appointment_details" +
                "FROM appointments;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            allAppts.add(mapRowToAppointment(results));
        }
        return allAppts;
    }

    @Override
    public Appointment getApptById(int apptId) {
        return null;
    }

    @Override
    public List<Appointment> getAllApptsByDate(LocalDate date) {
        List<Appointment> allApptsByDate = new ArrayList<>();
        String sql = "SELECT appointment_id, patient_id, provider_id, appointment_date, appt_start_time, appt_end_time, status, appointment_reason, appointment_details" +
                     "FROM appointments" +
                     "WHERE appointment_date = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, date);
        while (results.next()) {
            allApptsByDate.add(mapRowToAppointment(results));
        }
        return allApptsByDate;
    }

    @Override
    public List<Appointment> getAllApptsByDateByProviderId(LocalDate date, int providerId) {
        List<Appointment> allApptsByDate = new ArrayList<>();
        String sql = "SELECT appointment_id, patient_id, provider_id, appointment_date, appt_start_time, appt_end_time, status, appointment_reason, appointment_details" +
                "FROM appointments" +
                "WHERE appointment_date = ? AND provider_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, date, providerId);
        while (results.next()) {
            allApptsByDate.add(mapRowToAppointment(results));
        }
        // TODO: handle the population of time slots based on the now populated appointments list
        return allApptsByDate;
    }

    private Appointment mapRowToAppointment(SqlRowSet rowSet) {
        Appointment appointment = new Appointment();
        appointment.setId(rowSet.getInt("appointment_id"));
        appointment.setPatientId(rowSet.getInt("patient_id"));
        appointment.setProviderId(rowSet.getInt("provider_id"));
        if (rowSet.getDate("appointment_date") != null) {
            appointment.setAppointmentDate(rowSet.getDate("appointment_date").toLocalDate());
        }
        if(rowSet.getTime("appt_start_time") != null) {
            appointment.setApptStartTime(rowSet.getTime("appt_start_time").toLocalTime());
        }
        if(rowSet.getTime("appt_end_time") != null) {
            appointment.setApptEndTime(rowSet.getTime("appt_end_time").toLocalTime());
        }
        appointment.setStatus(rowSet.getString("status"));
        appointment.setAppointmentReason(rowSet.getString("appointment_reason"));
        appointment.setAppointmentDetails(rowSet.getString("appointment_details"));

        return appointment;
    }
}
