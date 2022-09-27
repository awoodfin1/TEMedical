package com.techelevator.dao;

import com.techelevator.model.Provider;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Time;
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
    public Time getProviderAvailStartTime() {
        return null;
    }

    @Override
    public Time getProviderAvailEndTime() {
        return null;
    }
}
