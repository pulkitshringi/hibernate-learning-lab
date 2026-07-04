package com.pulkit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.util.Arrays;

@Entity
public class Student {
    @Id
    @GeneratedValue() // automatically created.
    private Integer sId;
    private String sName;
    @Lob
    private byte[] image;
    @Lob
    private char[] textFile;

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public char[] getTextFile() {
        return textFile;
    }

    public void setTextFile(char[] textFile) {
        this.textFile = textFile;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", image=" + Arrays.toString(image) +
                ", textFile=" + Arrays.toString(textFile) +
                '}';
    }
}
