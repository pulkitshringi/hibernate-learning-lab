package com.pulkit.entitiy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    private Integer sId;
    private String name;

    @ManyToMany (cascade = CascadeType.ALL)
    List<Courses> coursesList = new ArrayList<>();

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Courses> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Courses> coursesList) {
        this.coursesList = coursesList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", name='" + name + '\'' +
                ", coursesList=" + coursesList +
                '}';
    }
}
