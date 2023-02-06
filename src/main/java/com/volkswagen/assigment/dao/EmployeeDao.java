package com.volkswagen.assigment.dao;

import com.volkswagen.assigment.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
