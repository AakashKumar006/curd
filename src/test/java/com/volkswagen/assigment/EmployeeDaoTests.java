package com.volkswagen.assigment;

import com.volkswagen.assigment.dao.EmployeeDao;
import com.volkswagen.assigment.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.Date;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeDaoTests {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void addEmployeeTest() {
        Employee employee= Employee.builder()
                .employeeName("Aakash")
                .employeeSalary("345")
                .dateOfJoining(new Date())
                .build();
        employeeDao.save(employee);
        Assertions.assertThat(employee.getEmployeeId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void getEmployeeTest() {
        Employee employee = employeeDao.findById(1).get();
        Assertions.assertThat(employee.getEmployeeId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void updateEmployee() {
        Employee employee =  employeeDao.findById(1).get();
        employee.setEmployeeName("Aakash");
        Employee employeeUpdated = employeeDao.save(employee);
        Assertions.assertThat(employeeUpdated.getEmployeeName()).isEqualTo("Aakash");
    }

   /* @Test
    @Order(4)
    @Rollback(value = false)
    public void deleteEmployee() {
        Employee employee = employeeDao.findById(1).get();
        employeeDao.delete(employee);
        Employee employee1=null;
        Optional<Employee> optionalEmployee=employeeDao.findByName("Aakash") ;
        if(optionalEmployee.isPresent())
        {
            employee1=optionalEmployee.get();
        }
        Assertions.assertThat(employee1).isNull();;
        }*/
}
