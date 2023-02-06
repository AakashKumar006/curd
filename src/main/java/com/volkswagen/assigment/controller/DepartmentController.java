package com.volkswagen.assigment.controller;

import com.volkswagen.assigment.model.Department;
import com.volkswagen.assigment.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {

    @Autowired
    DepartmentServiceImpl departmentServiceImpl;

    @RequestMapping("/department")
    public List<Department> getALlEmployee (){
        return departmentServiceImpl.getAllDepartment();
    }

    @PostMapping("/department/add")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        department.setDepartmentLocation(department.getParentLocation());
        return new ResponseEntity<>(departmentServiceImpl.addDepartment(department), HttpStatus.OK);
    }
}
