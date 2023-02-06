package com.volkswagen.assigment.controller;

import com.volkswagen.assigment.model.Employee;
import com.volkswagen.assigment.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @RequestMapping("/")
    public String home() {
        return "Employee Management System";
    }

    @RequestMapping("/employee/{Id}")
    public ResponseEntity<Employee> getEmployee (@PathVariable("Id") Integer employeeId) {
        return new ResponseEntity<>(employeeServiceImpl.getEmployee(employeeId), HttpStatus.OK);
    }

    @RequestMapping("/employee")
    public ResponseEntity<List<Employee>> getALlEmployee () {
        List<Employee> list = employeeServiceImpl.getAllEmployee();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/employee/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employee.setDateOfJoining(new Date());
        return new ResponseEntity<>(employeeServiceImpl.addEmployee(employee),HttpStatus.OK);
    }

    @DeleteMapping("/employee/delete/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer employeeId){
        return new ResponseEntity<>(employeeServiceImpl.deleteEmployee(employeeId),HttpStatus.OK);
    }

    @PutMapping("/employee/update")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeServiceImpl.updateEmployee(employee),HttpStatus.OK);
    }
}
