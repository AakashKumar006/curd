package com.volkswagen.assigment.service;

import com.volkswagen.assigment.model.Department;
import com.volkswagen.assigment.model.Employee;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartment();

    Department addDepartment(Department department);


}
