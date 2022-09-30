package com.techelevator.controller;

import com.techelevator.dao.ProviderDao;
import com.techelevator.model.Provider;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ProviderController {
    private ProviderDao providerDao;

    public ProviderController(ProviderDao providerDao) {
        this.providerDao = providerDao;
    }

    @RequestMapping(value = "/providers", method = RequestMethod.GET)
    public List<Provider> getAllProviders() {
        return providerDao.getAllProviders();
    }

    @RequestMapping(value = "/providers/{id}", method = RequestMethod.GET)
    public Provider getProviderByProviderId(@RequestParam int providerId) {
        return providerDao.getProviderByProviderId(providerId);
    }

    @RequestMapping(value = "/provider/my-profile/", method = RequestMethod.PUT)
    public void updateProvider(@RequestBody Provider provider) {
        this.providerDao.updateProvider(provider);
    }
}
