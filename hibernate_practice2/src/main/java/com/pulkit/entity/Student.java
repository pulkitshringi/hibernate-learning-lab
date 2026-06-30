// com/pulkit/entity/Student.java
package com.pulkit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "StudentTable")
public class Student {
    @Id // Making id as primary key
    private Integer sId;
    private String sName;
    @Column(name = "Student_city") // changing column name from sCity to Student_city
    private String sCity;

    public Student() {
    }

    ; // zero parameterised constructor


    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsCity() {
        return sCity;
    }

    public void setsCity(String sCity) {
        this.sCity = sCity;
    }
}