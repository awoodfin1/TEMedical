package com.techelevator.dao;

import com.techelevator.model.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
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


}
