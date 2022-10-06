package com.techelevator.controller;

import com.techelevator.dao.OfficeDao;
import com.techelevator.model.Office;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class OfficeController {
    private OfficeDao officeDao;

    public OfficeController(OfficeDao officeDao){
        this.officeDao = officeDao;
    }

    @RequestMapping(value = "/office", method = RequestMethod.GET)
    public Office getOffice(){
        return officeDao.getOfficeById(1);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/office", method = RequestMethod.PUT)
    public void updateOffice(@RequestBody Office office){
        officeDao.updateOfficeInfo(office);
    }
}




