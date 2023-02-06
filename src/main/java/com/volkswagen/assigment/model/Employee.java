package com.volkswagen.assigment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tbl_employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pk_employee", unique = true, nullable = false)
    private Integer employeeId;

    @Column(name="employee_name")
    private String employeeName;

    @OneToOne
    @JoinColumn (name="fk_department",nullable = true)
    private Department Department;

    @OneToOne
    @JoinColumn(name="fk_location",nullable = true)
    private Location location;

    @Column(name="employee_date_of_joining")
    private Date dateOfJoining;

    @Column(name="employee_salary")
    private String employeeSalary;

    @ManyToMany
    @JoinTable(name = "emp_pro_tbl",joinColumns = @JoinColumn(name = "fk_employee"),inverseJoinColumns = @JoinColumn(name = "fk_project"))
    private List<Project> employeeProject;
}
