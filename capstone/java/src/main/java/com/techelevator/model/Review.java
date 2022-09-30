package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Review {
    private int id;
    private int officeId;
    private int patientId;
    private int providerId;
    private String reviewText;
    private LocalDate reviewDate;
    private LocalTime reviewTime;
    private int providerRating;
    private String providerResponseText;
    private LocalDate responseDate;
    private LocalTime responseTime;

    public Review() {}

    public Review(int id, int officeId, int patientId, int providerId, String reviewText, LocalDate reviewDate, LocalTime reviewTime, int providerRating, String providerResponseText, LocalDate responseDate, LocalTime responseTime) {
        this.id = id;
        this.officeId = officeId;
        this.patientId = patientId;
        this.providerId = providerId;
        this.reviewText = reviewText;
        this.reviewDate = reviewDate;
        this.reviewTime = reviewTime;
        this.providerRating = providerRating;
        this.providerResponseText = providerResponseText;
        this.responseDate = responseDate;
        this.responseTime = responseTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    public LocalTime getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(LocalTime reviewTime) {
        this.reviewTime = reviewTime;
    }

    public int getProviderRating() {
        return providerRating;
    }

    public void setProviderRating(int providerRating) {
        this.providerRating = providerRating;
    }

    public String getProviderResponseText() {
        return providerResponseText;
    }

    public void setProviderResponseText(String providerResponseText) {
        this.providerResponseText = providerResponseText;
    }

    public LocalDate getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(LocalDate responseDate) {
        this.responseDate = responseDate;
    }

    public LocalTime getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(LocalTime responseTime) {
        this.responseTime = responseTime;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", officeId=" + officeId +
                ", patientId=" + patientId +
                ", providerId=" + providerId +
                ", reviewText='" + reviewText + '\'' +
                ", reviewDate=" + reviewDate +
                ", reviewTime=" + reviewTime +
                ", providerRating=" + providerRating +
                ", providerResponseText='" + providerResponseText + '\'' +
                ", responseDate=" + responseDate +
                ", responseTime=" + responseTime +
                '}';
    }
}
