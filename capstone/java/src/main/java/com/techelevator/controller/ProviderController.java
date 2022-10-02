package com.techelevator.controller;

import com.techelevator.dao.ProviderDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Provider;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ProviderController {
    private ProviderDao providerDao;
    private UserDao userDao;

    public ProviderController(ProviderDao providerDao, UserDao userDao) {
        this.providerDao = providerDao;
        this.userDao = userDao;
    }

    @RequestMapping(value = "/providers", method = RequestMethod.GET)
    public List<Provider> getAllProviders() {
        return providerDao.getAllProviders();
    }

    @RequestMapping(value = "/providers/{providerId}", method = RequestMethod.GET)
    public Provider getProviderByProviderId(@PathVariable int providerId) {
        return providerDao.getProviderByProviderId(providerId);
    }

    @RequestMapping(value = "/provider/my-profile", method = RequestMethod.PUT)
    public void updateProvider(@RequestBody Provider provider) {
        this.providerDao.updateProvider(provider);
    }

    @RequestMapping(value = "/provider/my-profile", method = RequestMethod.GET)
    public Provider getProviderByUsername(Principal principal) {
        return providerDao.getProviderByUserId(userDao.findIdByUsername(principal.getName()));
    }
}
