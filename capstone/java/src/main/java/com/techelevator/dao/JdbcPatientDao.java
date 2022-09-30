package com.techelevator.dao;

import com.techelevator.model.Patient;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
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
    public void createPatient(int userId, String first_name, String last_name) {
        String sql = "INSERT INTO patient (user_id, first_name, last_name) VALUES (?,?,?)";
        jdbcTemplate.update(sql, userId, first_name, last_name);
    }

    @Override
    public void updatePatientInfo(Patient newPatient) {
        int id = newPatient.getId();
        String firstName = newPatient.getFirstName();
        String lastName = newPatient.getLastName();
        String phoneNumber = newPatient.getPhone_number();
        String email_address = newPatient.getEmail_address();
        LocalDate birthdate = newPatient.getBirthdate();
        String healthText = newPatient.getHealth_issues_description();

        String sql = "UPDATE patient SET first_name = ?, last_name = ?, phone_number = ?, ";
        sql += "email_address = ?, birthdate = ?, health_issues_description = ? WHERE patient_id = ?;";

        try{
            jdbcTemplate.update(sql, firstName, lastName, phoneNumber, email_address, birthdate, healthText, id);
        } catch (DataAccessException e){
            System.out.println("Unable to update patient: " + e.getMessage());
        }
    }


}
