package com.volkswagen.assigment.service;

import com.volkswagen.assigment.dao.EmployeeDao;
import com.volkswagen.assigment.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = employeeDao.findAll();
        return employees;
    }

    @Override
    public Employee getEmployee(Integer employeeId) {
        Optional<Employee> optionalEmployee = employeeDao.findById(employeeId);
        if(optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            return employee;
        } else {
            return null;
        }
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public String deleteEmployee(Integer employeeId) {
        Optional<Employee> optionalEmployee = employeeDao.findById(employeeId);
        if(optionalEmployee.isPresent()){
            employeeDao.deleteById(employeeId);
            return "employee deleted with id : "+employeeId;
        }
       else return "Employee not exist";

    }

    @Override
    public String updateEmployee(Employee employee) {
        Optional<Employee> OptionalEmployee = employeeDao.findById(employee.getEmployeeId());
        if(OptionalEmployee.isPresent()){
            Employee currEmployee = OptionalEmployee.get();
            currEmployee.setEmployeeSalary(employee.getEmployeeSalary());
            currEmployee.setDepartment(employee.getDepartment());
            currEmployee.setEmployeeName(employee.getEmployeeName());
            currEmployee.setLocation(employee.getLocation());
            employeeDao.save(currEmployee);
            return "employee update "+ employee.getEmployeeId();
        } else
        return null;
    }
}
