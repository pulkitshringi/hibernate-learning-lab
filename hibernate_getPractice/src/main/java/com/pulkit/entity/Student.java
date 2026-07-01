package com.pulkit.entity;

import jakarta.persistence.*;

@Entity
@Table(name="StudentTable")
public class Student {
    @Id
    private Integer sid;
    @Column(name="Student_city")
    private String scity;
    private String sName;

    public Student(){
        System.out.println("Student class Constructor :)");
    };

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", scity='" + scity + '\'' +
                ", sName='" + sName + '\'' +
                '}';
    }
}
