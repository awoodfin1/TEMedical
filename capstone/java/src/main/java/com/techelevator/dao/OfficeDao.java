package com.techelevator.dao;

import com.techelevator.model.Office;

import java.util.List;

public interface OfficeDao {

    List<Office> getAllOffices();

    Office getOfficeById(int id);

    List<Office> getOfficesByState(String state);

    List<Office> getOfficesByCity(String city);
}
