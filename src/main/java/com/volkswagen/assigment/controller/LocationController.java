package com.volkswagen.assigment.controller;

import com.volkswagen.assigment.model.Employee;
import com.volkswagen.assigment.model.Location;
import com.volkswagen.assigment.service.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LocationController {

    @Autowired
    private LocationServiceImpl locationServiceImpl;

    @RequestMapping("/location")
    public ResponseEntity<List<Location>> getAllLocation() {
        List<Location> location = locationServiceImpl.getAllLocation();
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @PostMapping("/location/add")
    public ResponseEntity<Location> addLocation(@RequestBody Location location) {
        return new ResponseEntity<>(locationServiceImpl.addLocation(location),HttpStatus.OK);
    }


}
