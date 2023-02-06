package com.volkswagen.assigment.service;

import com.volkswagen.assigment.model.Location;

import java.util.List;

public interface LocationService {
    List<Location> getAllLocation();

    Location addLocation(Location location);
}
