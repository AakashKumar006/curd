package com.volkswagen.assigment.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "tbl_department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_department", unique = true, nullable = false)
    private Integer departmentId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="fk_department_location",nullable = true)
    private Location departmentLocation;

    @OneToMany(mappedBy = "departmentProject")
    @JsonManagedReference
    private Set<Project> departmentProject;

    @Transient
    private Location parentLocation;

    @Column(name = "department_Name")
    private String departmentName;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Location getDepartmentLocation() {
        return departmentLocation;
    }

    public void setDepartmentLocation(Location departmentLocation) {
        this.departmentLocation = departmentLocation;
    }

    public Set<Project> getDepartmentProject() {
        return departmentProject;
    }

    public void setDepartmentProject(Set<Project> departmentProject) {
        this.departmentProject = departmentProject;
    }

    public Location getParentLocation() {
        return parentLocation;
    }

    public void setParentLocation(Location parentLocation) {
        this.parentLocation = parentLocation;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(Integer departmentId, Location departmentLocation, Set<Project> departmentProject, Location parentLocation, String departmentName) {
        this.departmentId = departmentId;
        this.departmentLocation = departmentLocation;
        this.departmentProject = departmentProject;
        this.parentLocation = parentLocation;
        this.departmentName = departmentName;
    }

    public Department() {
    }


}
