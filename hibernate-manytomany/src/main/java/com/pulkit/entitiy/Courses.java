package com.pulkit.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Courses {
    @Id
    private Integer cId;
    private String courseName;
    @ManyToMany(mappedBy = "coursesList")
    List<Student> studentList = new ArrayList<>();

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "cId=" + cId +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
