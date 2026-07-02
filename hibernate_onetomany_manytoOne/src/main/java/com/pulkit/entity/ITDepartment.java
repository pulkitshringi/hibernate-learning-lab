package com.pulkit.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class ITDepartment {
    @Id
    private Integer id;
    private String DepartmentName;
    @OneToMany(mappedBy = "itDepartment", cascade = CascadeType.ALL) // as One Department can have multiple employees
    private List<Employees> Employees_list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public List<Employees> getEmployees_list() {
        return Employees_list;
    }

    public void setEmployees_list(List<Employees> employees_list) {
        Employees_list = employees_list;
    }
}
