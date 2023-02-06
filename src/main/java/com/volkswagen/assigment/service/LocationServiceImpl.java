package com.volkswagen.assigment.service;

import com.volkswagen.assigment.dao.LocationDao;
import com.volkswagen.assigment.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired private LocationDao locationDao;

    @Override
    public List<Location> getAllLocation() {
        return locationDao.findAll();
    }

    @Override
    public Location addLocation(Location location) {
        return locationDao.save(location);
    }
}
