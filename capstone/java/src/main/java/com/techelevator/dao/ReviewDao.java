package com.techelevator.dao;

import com.techelevator.model.Review;

import java.util.List;

public interface ReviewDao {

    List<Review> getAllReviews();

    Review getReviewById(int id);

    List<Review> getAllReviewsByProvider(int providerId);

    void createReview(Review review);


}
