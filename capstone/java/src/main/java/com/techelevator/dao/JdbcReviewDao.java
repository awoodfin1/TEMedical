package com.techelevator.dao;

import com.techelevator.model.Review;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReviewDao implements ReviewDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcReviewDao(DataSource dataSource){
        this. jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Review> getAllReviews() {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM review";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()){
                reviews.add(mapToReview(results));
            }
        }catch (DataAccessException e){
            System.out.println("Unable to get reviews: " + e.getMessage());
        }
        return reviews;
    }

    @Override
    public Review getReviewById(int id) {
        Review review = new Review();
        String sql = "SELECT * FROM review WHERE review_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()){
            review = mapToReview(results);
        }
        return review;
    }

    @Override
    public List<Review> getAllReviewsByProvider(int providerId) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM review WHERE provider_id = ?";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, providerId);
            while(results.next()){
                reviews.add(mapToReview(results));
            }
        }catch (DataAccessException e){
            System.out.println("Unable to get reviews: " + e.getMessage());
        }
        return reviews;
    }

    @Override
    public void createReview(Review review) {
        String sql = "INSERT INTO review (office_id, patient_id, provider_id, review_text, ";
        sql += "review_date, review_time, provider_rating) VALUES (?,?,?,?,?,?,?);";
        jdbcTemplate.update(sql, review.getOfficeId(), review.getPatientId(), review.getProviderId(),
                review.getReviewText(), review.getReviewDate(), review.getReviewTime(), review.getProviderRating());
    }

    public Review mapToReview(SqlRowSet rs){
        Review review = new Review();
        review.setId(rs.getInt("review_id"));
        review.setPatientId(rs.getInt("patient_id"));
        review.setProviderId(rs.getInt("provider_id"));
        review.setOfficeId(rs.getInt("office_id"));
        review.setReviewText(rs.getString("review_text"));
        review.setReviewDate(rs.getDate("review_date").toLocalDate());
        review.setReviewTime(rs.getTime("review_time").toLocalTime());
        review.setProviderRating(rs.getInt("provider_rating"));
        review.setProviderResponseText(rs.getString("provider_response_text"));
        review.setResponseDate(rs.getDate("response_date").toLocalDate());
        review.setResponseTime(rs.getTime("response_time").toLocalTime());
        return review;
    }
}
