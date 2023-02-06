package com.volkswagen.assigment.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tbl_Project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_project", unique = true, nullable = false)
    private Integer projectId;

    @Column(name = "project_name")
    private String projectName;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "Fk_Department_project",nullable = false)
    private Department departmentProject;

    @ManyToMany
    @JoinTable(name = "emp_pro_tbl",joinColumns = @JoinColumn(name = "fk_project"),inverseJoinColumns = @JoinColumn(name = "fk_employee"))
    private List<Employee> employeeProject;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Department getDepartmentProject() {
        return departmentProject;
    }

    public void setDepartmentProject(Department departmentProject) {
        this.departmentProject = departmentProject;
    }

    public List<Employee> getEmployeeProject() {
        return employeeProject;
    }

    public void setEmployeeProject(List<Employee> employeeProject) {
        this.employeeProject = employeeProject;
    }

    public Project() {
    }
}
