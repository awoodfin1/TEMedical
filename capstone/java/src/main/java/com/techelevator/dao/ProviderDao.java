package com.techelevator.dao;

import com.techelevator.model.Provider;

import java.sql.Time;
import java.util.List;

public interface ProviderDao {

    // create

    // read
    List<Provider> getAllProviders();

    Time getProviderAvailStartTime();

    Time getProviderAvailEndTime();

    // update

    // delete

}
