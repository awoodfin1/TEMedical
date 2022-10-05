package com.techelevator.dao;

import com.techelevator.model.Office;
import com.techelevator.model.OfficeNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcOfficeDao implements OfficeDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcOfficeDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Office> getAllOffices() {
        List<Office> offices = new ArrayList<>();
        String sql = "SELECT * FROM office";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Office office = mapRowToOffice(results);
            offices.add(office);
        }
        return offices;
    }

    @Override
    public Office getOfficeById(int id) {
        String sql = "SELECT * FROM office WHERE office_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToOffice(results);
        } else {
            throw new OfficeNotFoundException();
        }
    }

    @Override
    public List<Office> getOfficesByState(String state) {
        List<Office> offices = new ArrayList<>();
        String sql = "SELECT * FROM office WHERE state = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, state);
        while (results.next()) {
            Office office = mapRowToOffice(results);
            offices.add(office);
        }
        return offices;
    }

    @Override
    public List<Office> getOfficesByCity(String city) {
        List<Office> offices = new ArrayList<>();
        String sql = "SELECT * FROM office WHERE city = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, city);
        while (results.next()) {
            Office office = mapRowToOffice(results);
            offices.add(office);
        }
        return offices;
    }

    //TODO: Lucas will update on 10/5
    @Override
    public void updateOfficeInfo(Office office) {
        String sql = "UPDATE office SET WHERE office_id = ?"; //WAITING FOR DATABASE UPDATE
        try {
            jdbcTemplate.update(sql,office.getId());
        } catch (DataAccessException e) {
            System.out.println("Unable to update office: " + e.getMessage());
        }
    }

    private Office mapRowToOffice(SqlRowSet rs) {
        Office office = new Office();
        office.setId(rs.getInt("office_id"));
        office.setName(rs.getString("office_name"));
        office.setTagLine(rs.getString("tag_line"));
        office.setStreetAddress(rs.getString("street_address"));
        office.setCity(rs.getString("city"));
        office.setStateAbbr(rs.getString("state"));
        office.setZipcode(rs.getInt("zipcode"));
        office.setOpenTime(rs.getTime("office_open_time"));
        office.setCloseTime(rs.getTime("office_close_time"));
        office.setPhoneNumber(rs.getString("phone_number"));
        office.setCostPerHour(rs.getBigDecimal("cost_per_hour"));
        office.setHasApptDelay(rs.getBoolean("has_appt_delay"));
        return office;
    }
}
