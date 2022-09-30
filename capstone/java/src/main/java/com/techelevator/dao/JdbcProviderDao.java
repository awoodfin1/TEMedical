package com.techelevator.dao;

import com.techelevator.model.Provider;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcProviderDao implements ProviderDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcProviderDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Provider> getAllProviders() {
        List<Provider> providerList = new ArrayList<>();
        String sql = "SELECT provider_id, user_id, title, first_name, last_name, post_nominals, gender, language, rating, phone_number, bio, photo_URL " +
                     "FROM provider;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            providerList.add(mapRowToProvider(results));
        }
        return providerList;
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

    @Override
    public void createProvider(int userId, String first_name, String last_name) {
        String sql = "INSERT INTO provider (user_id, first_name, last_name) VALUES (?,?,?)";
        jdbcTemplate.update(sql, userId, first_name, last_name);
    }

    private Provider mapRowToProvider(SqlRowSet rs) {
        Provider provider = new Provider();
        provider.setId(rs.getInt("provider_id"));
        provider.setUserId(rs.getInt("user_id"));
        provider.setTitle(rs.getString("title"));
        provider.setFirstName(rs.getString("first_name"));
        provider.setLastName(rs.getString("last_name"));
        provider.setPostNominals(rs.getString("post_nominals"));
        provider.setGender(rs.getString("gender"));
        provider.setLanguage(rs.getString("language"));
        provider.setRating(rs.getDouble("rating"));
        provider.setPhoneNumber(rs.getString("phone_number"));
        provider.setBio(rs.getString("bio"));
        provider.setPhotoUrl(rs.getString("photo_URL"));
        return provider;
    }
}
