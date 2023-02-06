package com.volkswagen.assigment.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="tbl_Location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_location", unique = true, nullable = true)
    private Integer locationId;

    @Column(name = "location_name")
    private String LocationName;

    @OneToMany(mappedBy = "departmentLocation")
    @JsonManagedReference
    private Set<Department> departmentLocation;

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String locationName) {
        LocationName = locationName;
    }

    public Set<Department> getDepartmentLocation() {
        return departmentLocation;
    }

    public void setDepartmentLocation(Set<Department> departmentLocation) {
        this.departmentLocation = departmentLocation;
    }
    public Location() {

    }

    public Location(Integer locationId, String locationName, Set<Department> departmentLocation) {
        this.locationId = locationId;
        LocationName = locationName;
        this.departmentLocation = departmentLocation;
    }



}
