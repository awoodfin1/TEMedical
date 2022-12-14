package com.techelevator.dao;

import com.techelevator.model.Provider;
import com.techelevator.model.Review;
import org.springframework.dao.DataAccessException;
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
    private ReviewDao reviewDao;

    public JdbcProviderDao(DataSource dataSource, ReviewDao reviewDao) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.reviewDao = reviewDao;
    }


    @Override
    public List<Provider> getAllProviders() {
        List<Provider> providerList = new ArrayList<>();
        String sql = "SELECT provider_id, user_id, title, first_name, last_name, post_nominals, specialty, gender, language, rating, phone_number, bio, photo_URL, display_appt_update " +
                     "FROM provider " +
                     "ORDER BY first_name;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            providerList.add(mapRowToProvider(results));
        }
        return providerList;
    }

    @Override
    public Integer getProviderIdByUserId(int userId){
        String sql = "SELECT provider_id FROM provider WHERE user_id = ?";
        Integer id = jdbcTemplate.queryForObject(sql,Integer.class, userId);
        return id;
    }

    @Override
    public Provider getProviderByProviderId(int id) {
        Provider provider = null;
        String sql = "SELECT provider_id, user_id, title, first_name, last_name, post_nominals, specialty, gender, language, rating, phone_number, bio, photo_URL, display_appt_update " +
                     "FROM provider " +
                     "WHERE provider_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if (result.next()) {
            provider = mapRowToProvider(result);
        }
        return provider;
    }

    @Override
    public Provider getProviderByUserId(int id) {
        Provider provider = null;
        String sql = "SELECT provider_id, user_id, title, first_name, last_name, post_nominals, specialty, gender, language, rating, phone_number, bio, photo_URL, display_appt_update " +
                "FROM provider " +
                "WHERE user_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if (result.next()) {
            provider = mapRowToProvider(result);
        }
        return provider;
    }

    @Override
    public void updateProvider(Provider provider) {
        String sql = "UPDATE provider " +
                     "SET " +
                        "title = ?, " +
                        "first_name = ?, " +
                        "last_name = ?, " +
                        "post_nominals = ?, " +
                        "specialty = ?, " +
                        "gender = ?, " +
                        "language = ?, " +
                        "rating = ?, " +
                        "phone_number = ?, " +
                        "bio = ?, " +
                        "photo_URL = ?, " +
                        "display_appt_update = ? " +
                     "WHERE provider_id = ?;";
        try {
            jdbcTemplate.update(sql, provider.getTitle(), provider.getFirstName(), provider.getLastName(), provider.getPostNominals(), provider.getSpecialty(), provider.getGender(), provider.getLanguage(), provider.getRating(), provider.getPhoneNumber(), provider.getBio(), provider.getPhotoUrl(), provider.isDisplayApptUpdate(), provider.getId());
        } catch (DataAccessException e) {
            System.out.println("Unable to update provider: " + e.getMessage());
        }
    }

    public double updateRating(List<Review> reviewList, int providerId){
        double sum = 0.0;
        int count = 0;
        for (Review review:reviewList) {
            sum += review.getProviderRating();
            count++;
        }
        double avg = sum / count;
        String sql = "UPDATE provider SET rating = ? WHERE provider_id = ?;";
        jdbcTemplate.update(sql, avg, providerId);
        return avg;
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

    @Override
    public int getIdByProviderFullName(String fullName) {
        String sql = "SELECT provider_id FROM provider WHERE (title ||' '|| first_name || ' ' || last_name || ' ' || post_nominals) = ?;";
        try {
            return jdbcTemplate.queryForObject(sql, Integer.class, fullName);
        } catch (DataAccessException e) {
            System.out.println("Unable to get provider: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public void toggleOnDisplayApptUpdate(int providerId) {
        String updateSql = "UPDATE provider SET display_appt_update = ? WHERE provider_id = ?;";
        try {
            jdbcTemplate.update(updateSql, true, providerId);

        } catch (DataAccessException e) {
            System.out.println("Appointment notification will not be displayed at this moment " + e.getMessage());
        }
    }

    @Override
    public void toggleOffDisplayApptUpdate(int providerId) {
        String updateSql = "UPDATE provider SET display_appt_update = ? WHERE provider_id = ?;";
        try {
            jdbcTemplate.update(updateSql, false, providerId);

        } catch (DataAccessException e) {
            System.out.println("Appointment notification will still be displayed at this moment " + e.getMessage());
        }
    }

    private Provider mapRowToProvider(SqlRowSet rs) {
        Provider provider = new Provider();
        provider.setId(rs.getInt("provider_id"));
        provider.setUserId(rs.getInt("user_id"));
        provider.setTitle(rs.getString("title"));
        provider.setFirstName(rs.getString("first_name"));
        provider.setLastName(rs.getString("last_name"));
        provider.setPostNominals(rs.getString("post_nominals"));
        provider.setSpecialty(rs.getString("specialty"));
        provider.setGender(rs.getString("gender"));
        provider.setLanguage(rs.getString("language"));
        provider.setRating(updateRating(reviewDao.getAllReviewsByProvider(provider.getId()), provider.getId()));
        provider.setPhoneNumber(rs.getString("phone_number"));
        provider.setBio(rs.getString("bio"));
        provider.setPhotoUrl(rs.getString("photo_URL"));
        provider.setDisplayApptUpdate(rs.getBoolean("display_appt_update"));
        return provider;
    }
}
