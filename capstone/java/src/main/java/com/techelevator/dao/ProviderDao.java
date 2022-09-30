package com.techelevator.dao;

import com.techelevator.model.Provider;

import java.time.LocalTime;
import java.util.List;

public interface ProviderDao {

    // create

    // read
    List<Provider> getAllProviders();

    Provider getProviderByProviderId(int id);

    void updateProvider(Provider provider);

    LocalTime getProviderAvailStartTime(int providerId);

    LocalTime getProviderAvailEndTime(int providerId);

    void createProvider(int userId, String first_name, String last_name);

    // update

    // delete

}
