package com.techelevator.dao;

import com.techelevator.model.Patient;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import javax.sql.RowSet;
import java.time.LocalDate;

@Component
public class JdbcPatientDao implements PatientDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcPatientDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Integer getPatientIdByUserId(int userId){
        String sql = "SELECT patient_id FROM patient WHERE user_id = ?";
        Integer id = jdbcTemplate.queryForObject(sql,Integer.class, userId);
        return id;
    }

    @Override
    public Patient getPatientByUserId(int userId){
        Patient patient = null;
        String sql = "SELECT patient_id, user_id, first_name, last_name, phone_number, email_address, birthdate, health_issues_description, display_appt_update " +
                     "FROM patient WHERE user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);
        if (result.next()) {
            patient = mapRowToPatient(result);
        }
        return patient;
    }

    @Override
    public void createPatient(int userId, String first_name, String last_name) {
        String sql = "INSERT INTO patient (user_id, first_name, last_name) VALUES (?,?,?)";
        jdbcTemplate.update(sql, userId, first_name, last_name);
    }

    @Override
    public void updatePatientInfo(Patient newPatient) {
        int id = newPatient.getId();
        String firstName = newPatient.getFirstName();
        String lastName = newPatient.getLastName();
        String phoneNumber = newPatient.getPhoneNumber();
        String email_address = newPatient.getEmailAddress();
        LocalDate birthdate = newPatient.getBirthdate();
        String healthText = newPatient.getHealthIssuesDescription();
        boolean displayApptUpdate = newPatient.isDisplayApptUpdate();

        String sql = "UPDATE patient SET first_name = ?, last_name = ?, phone_number = ?, ";
        sql += "email_address = ?, birthdate = ?, health_issues_description = ?, display_appt_update = ? WHERE patient_id = ?;";

        try {
            jdbcTemplate.update(sql, firstName, lastName, phoneNumber, email_address, birthdate, healthText, displayApptUpdate, id);
        } catch (DataAccessException e) {
            System.out.println("Unable to update patient: " + e.getMessage());
        }
    }

    @Override
    public Patient getPatientByApptId(int apptId) {
        Patient patient = new Patient();
        String sql = "SELECT patient.patient_id, user_id, first_name, last_name, phone_number, email_address, birthdate, health_issues_description, display_appt_update " +
                "FROM patient " +
                "JOIN appointment ON patient.patient_id = appointment.patient_id " +
                "WHERE appointment_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, apptId);
        if (result.next()) {
            patient = mapRowToPatient(result);
        }
        return patient;
    }

    private Patient mapRowToPatient(SqlRowSet rs) {
        Patient patient = new Patient();
        patient.setId(rs.getInt("patient_id"));
        patient.setUserId(rs.getInt("user_id"));
        patient.setFirstName(rs.getString("first_name"));
        patient.setLastName(rs.getString("last_name"));
        patient.setPhoneNumber(rs.getString("phone_number"));
        patient.setEmailAddress(rs.getString("email_address"));
        patient.setBirthdate(rs.getDate("birthdate").toLocalDate());
        patient.setHealthIssuesDescription(rs.getString("health_issues_description"));
        patient.setDisplayApptUpdate(rs.getBoolean("display_appt_update"));
        return patient;
    }
}
