package com.techelevator.dao;

import com.techelevator.model.Appointment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.Time;
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
        return null;
    }

    @Override
    public Appointment getApptById() {
        return null;
    }

    @Override
    public List<Appointment> getAllApptsByDate() {
        return null;
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
            appointment.setApptStartTime(Time.valueOf(rowSet.getTime("appt_start_time").toLocalTime()));
        }
        if(rowSet.getTime("appt_end_time") != null) {
            appointment.setApptEndTime(Time.valueOf(rowSet.getTime("appt_end_time").toLocalTime()));
        }
        appointment.setStatus(rowSet.getString("status"));
        appointment.setAppointmentReason(rowSet.getString("appointment_reason"));
        appointment.setAppointmentDetails(rowSet.getString("appointment_details"));

        return appointment;
    }
}
