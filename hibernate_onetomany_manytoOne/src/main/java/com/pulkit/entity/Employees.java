package com.pulkit.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Employees {
    @Id
    private Integer id;
    private String employeeName;
    @ManyToOne(cascade = CascadeType.ALL) // as Many Employees can belong to single department
    ITDepartment itDepartment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public ITDepartment getItDepartment() {
        return itDepartment;
    }

    public void setItDepartment(ITDepartment itDepartment) {
        this.itDepartment = itDepartment;
    }
}
