package com.techelevator.controller;


import com.techelevator.dao.PatientDao;
import com.techelevator.dao.ProviderDao;
import com.techelevator.dao.ReviewDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Review;
import com.techelevator.model.ReviewDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ReviewController {
    private ReviewDao reviewDao;
    private ProviderDao providerDao;
    private PatientDao patientDao;
    private UserDao userDao;

    public ReviewController(ReviewDao reviewDao, ProviderDao providerDao, PatientDao patientDao, UserDao userDao){
        this.reviewDao = reviewDao;
        this.providerDao = providerDao;
        this.patientDao = patientDao;
        this.userDao = userDao;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/reviews", method = RequestMethod.GET)
    public List<Review> getAllReviews(){
        return reviewDao.getAllReviews();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/reviews/{providerId}")
    public List<Review> getReviewsByProviderId(@PathVariable int providerId){
        return reviewDao.getAllReviewsByProvider(providerId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/reviews", method = RequestMethod.POST)
    public void createReview(Principal principal, @RequestBody ReviewDTO reviewDTO) {
        int officeId = 1;
        int patientId = patientDao.getPatientIdByUserId(userDao.findIdByUsername(principal.getName()));
        int providerId = providerDao.getIdByProviderFullName(reviewDTO.getProviderFullName());
        String reviewText = reviewDTO.getReviewText();
        LocalDate today = java.time.LocalDate.now();
        LocalTime now = java.time.LocalTime.now();
//        LocalTime now = java.time.LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
        int providerRating = reviewDTO.getStarRating();
        Review newReview = new Review(officeId, patientId, providerId, reviewText, today, now, providerRating);
        if(providerId != 0) {
            reviewDao.createReview(newReview);
        }
    }
}
