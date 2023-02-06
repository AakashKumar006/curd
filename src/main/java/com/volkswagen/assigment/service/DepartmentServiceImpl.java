package com.volkswagen.assigment.service;

import com.volkswagen.assigment.dao.DepartmentDao;
import com.volkswagen.assigment.model.Department;
import com.volkswagen.assigment.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public List<Department> getAllDepartment() {
        List<Department> departmentList = departmentDao.findAll();
        for(Department department : departmentList) {
            Location location = new Location();
            location.setLocationId(department.getDepartmentLocation().getLocationId());
            location.setLocationName(department.getDepartmentLocation().getLocationName());
            department.setParentLocation(location);
        }
        return departmentList;
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentDao.save(department);
    }
}
