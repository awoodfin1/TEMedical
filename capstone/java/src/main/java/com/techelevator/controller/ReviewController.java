package com.techelevator.controller;


import com.techelevator.dao.ReviewDao;
import com.techelevator.model.Review;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ReviewController {
    private ReviewDao reviewDao;

    public ReviewController(ReviewDao reviewDao){
        this.reviewDao = reviewDao;
    }

    @RequestMapping(value = "/reviews", method = RequestMethod.GET)
    public List<Review> getAllReviews(){
        return reviewDao.getAllReviews();
    }
}
