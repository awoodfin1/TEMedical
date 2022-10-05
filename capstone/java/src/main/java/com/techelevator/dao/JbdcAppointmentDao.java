package com.techelevator.dao;

import com.techelevator.model.Appointment;
import com.techelevator.model.Patient;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JbdcAppointmentDao implements AppointmentDao {

    private final JdbcTemplate jdbcTemplate;
    private List<LocalTime> allPotentialApptStartTimes;

    public JbdcAppointmentDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        allPotentialApptStartTimes = new ArrayList<>();
        populateStartTimesList();
    }

    private void populateStartTimesList() {
        allPotentialApptStartTimes.add(LocalTime.of(9, 0));
        for (int i = 1; i < 16; i++) {
            allPotentialApptStartTimes.add(allPotentialApptStartTimes.get(i-1).plusMinutes(30));
        }
    }


    @Override
    public Appointment createAppointment(Appointment newAppointment) {
        String sql = "INSERT INTO appointment (patient_id, provider_id, appointment_date, " +
                "appt_start_time, appt_end_time, appointment_reason, appointment_details, is_new_patient) VALUES (?,?,?,?,?,?,?,?) RETURNING appointment_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, newAppointment.getPatientId(),
                newAppointment.getProviderId(), newAppointment.getAppointmentDate(),
                newAppointment.getApptStartTime(), newAppointment.getApptEndTime(), newAppointment.getAppointmentReason(),
                newAppointment.getAppointmentDetails(), newAppointment.isNewPatient());
        return getApptById(newId);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        List<Appointment> allAppts = new ArrayList<>();
        String sql = "SELECT appointment_id, patient_id, provider_id, appointment_date, appt_start_time, appt_end_time, status, appointment_reason, appointment_details, is_new_patient " +
                "FROM appointment;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            allAppts.add(mapRowToAppointment(results));
        }
        return allAppts;
    }

    @Override
    public Appointment getApptById(int apptId) {
        Appointment appointment = new Appointment();
        String sql = "SELECT * FROM appointment WHERE appointment_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, apptId);
        if(results.next()) {
            appointment = mapRowToAppointment(results);
        }
        return appointment;
    }

    @Override
    public List<Appointment> getAllApptsByPatientId(int patientId) {
        List<Appointment> allAppts = new ArrayList<>();
        String sql = "SELECT appointment_id, patient_id, provider_id, appointment_date, appt_start_time, appt_end_time, status, appointment_reason, appointment_details, is_new_patient " +
                "FROM appointment " +
                "WHERE patient_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
        while (results.next()) {
            allAppts.add(mapRowToAppointment(results));
        }
        return allAppts;
    }

    @Override
    public List<Appointment> getAllApptsByProviderId(int providerId) {
        List<Appointment> allAppts = new ArrayList<>();
        String sql = "SELECT appointment_id, patient_id, provider_id, appointment_date, appt_start_time, appt_end_time, status, appointment_reason, appointment_details, is_new_patient " +
                "FROM appointment " +
                "WHERE provider_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, providerId);
        while (results.next()) {
            allAppts.add(mapRowToAppointment(results));
        }
        return allAppts;
    }

    @Override
    public List<Appointment> getAllApptsByDateByPatientId(LocalDate date, int patientId) {
        List<Appointment> allApptsByDate = new ArrayList<>();
        String sql = "SELECT appointment_id, patient_id, provider_id, appointment_date, appt_start_time, appt_end_time, status, appointment_reason, appointment_details, is_new_patient " +
                     "FROM appointment " +
                     "WHERE appointment_date = ? AND patient_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, date, patientId);
        while (results.next()) {
            allApptsByDate.add(mapRowToAppointment(results));
        }
        return allApptsByDate;
    }

    @Override
    public List<Appointment> getAllApptsByDateByProviderId(LocalDate date, int providerId) {
        List<Appointment> allApptsByDate = new ArrayList<>();
        String sql = "SELECT appointment_id, patient_id, provider_id, appointment_date, appt_start_time, appt_end_time, status, appointment_reason, appointment_details, is_new_patient " +
                "FROM appointment " +
                "WHERE appointment_date = ? AND provider_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, date, providerId);
        while (results.next()) {
            allApptsByDate.add(mapRowToAppointment(results));
        }
        return allApptsByDate;
    }

    @Override
    public List<LocalTime> getApptStartTimes(LocalDate date, int providerId) {
        List<LocalTime> allApptStartTimes = new ArrayList<>();
        String sql = "SELECT appt_start_time " +
                     "FROM appointment " +
                     "WHERE appointment_date = ? AND provider_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, date, providerId);

        while(results.next()) {
            allApptStartTimes.add(results.getTime("appt_start_time").toLocalTime());
        }
        return allApptStartTimes;
    }

    @Override
    public List<LocalTime> getAvailability(LocalDate date, int providerId) {
        List<LocalTime> temp = this.allPotentialApptStartTimes;
        List<LocalTime> allApptStartTimes = getApptStartTimes(date, providerId);
        for (LocalTime eachStartTime : allApptStartTimes) {
            if (temp.contains(eachStartTime)) {
                temp.remove(temp.indexOf(eachStartTime));
            }
        }
        return temp;
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        String sql = "UPDATE appointment " +
                     "SET " +
                        "appointment_date = ?, " +
                        "appt_start_time = ?, " +
                        "appt_end_time = ?, " +
                        "status = ?, " +
                        "appointment_reason = ?, " +
                        "appointment_details = ? " +
                    "WHERE appointment_id = ?;";
        try {
            jdbcTemplate.update(sql, appointment.getAppointmentDate(), appointment.getApptStartTime(), appointment.getApptEndTime(), appointment.getStatus(), appointment.getAppointmentReason(), appointment.getAppointmentDetails(), appointment.getId());
        } catch (DataAccessException e) {
            System.out.println("Unable to update appointment: " + e.getMessage());
        }
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
        appointment.setNewPatient(rowSet.getBoolean("is_new_patient"));
        return appointment;
    }
}
