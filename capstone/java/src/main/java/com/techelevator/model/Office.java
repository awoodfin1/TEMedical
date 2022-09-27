package com.techelevator.model;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.sql.Time;

public class Office {

    private int id;
    private String streetAddress;
    private String city;
    private String stateAbbr;
    private int zipcode;
    private Time openTime;
    private Time closeTime;
    private String phoneNumber;
    @Min(0)
    private BigDecimal costPerHour;
    private boolean hasApptDelay;

    public Office() { }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateAbbr() {
        return this.stateAbbr;
    }

    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }

    public int getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public Time getOpenTime() {
        return this.openTime;
    }

    public void setOpenTime(Time openTime) {
        this.openTime = openTime;
    }

    public Time getCloseTime() {
        return this.closeTime;
    }

    public void setCloseTime(Time closeTime) {
        this.closeTime = closeTime;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getCostPerHour() {
        return this.costPerHour;
    }

    public void setCostPerHour(BigDecimal costPerHour) {
        this.costPerHour = costPerHour;
    }

    public boolean isHasApptDelay() {
        return this.hasApptDelay;
    }

    public void setHasApptDelay(boolean hasApptDelay) {
        this.hasApptDelay = hasApptDelay;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", stateAbbr='" + stateAbbr + '\'' +
                ", zipcode=" + zipcode +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", phoneNumber=" + phoneNumber +
                ", costPerHour=" + costPerHour +
                ", hasApptDelay=" + hasApptDelay +
                '}';
    }
}
