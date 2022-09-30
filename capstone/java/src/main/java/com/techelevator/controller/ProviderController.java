package com.techelevator.controller;

import com.techelevator.dao.ProviderDao;
import com.techelevator.model.Provider;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
