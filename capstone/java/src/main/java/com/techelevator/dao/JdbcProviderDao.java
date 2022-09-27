package com.techelevator.dao;

import com.techelevator.model.Provider;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

import java.time.LocalTime;
import java.util.List;

public class JdbcProviderDao implements ProviderDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcProviderDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Provider> getAllProviders() {
        return null;
    }

    @Override
    public LocalTime getProviderAvailStartTime(int providerId) {
        LocalTime providerAvailStartTime = null;
        String sql = "SELECT office_open_time" +
                     "FROM office" +
                     "JOIN provider_office ON office.office_id = provider_office.office_id" +
                     "WHERE provider_office.provider_id = ?;";
        LocalTime result = jdbcTemplate.queryForObject(sql, LocalTime.class, providerId);
        if (result != null) {
            providerAvailStartTime = result;
        }

        return providerAvailStartTime;
    }

    @Override
    public LocalTime getProviderAvailEndTime(int providerId) {
        LocalTime providerAvailEndTime = null;
        String sql = "SELECT office_close_time" +
                "FROM office" +
                "JOIN provider_office ON office.office_id = provider_office.office_id" +
                "WHERE provider_office.provider_id = ?;";
        LocalTime result = jdbcTemplate.queryForObject(sql, LocalTime.class, providerId);
        if (result != null) {
            providerAvailEndTime = result;
        }

        return providerAvailEndTime;
    }
}
