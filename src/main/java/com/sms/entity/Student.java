package com.sms.entity;


import jakarta.persistence.*;

import javax.validation.Valid;
import java.util.Date;

@Entity
@Table(name = "students")
@Valid
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String subject;

    private Integer grade;

    private Date createdAt;

    private String imageFileName;

    public Student(){}

    public Student(String firstName, String lastName, String subject, Integer grade, String imageFileName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        this.grade = grade;
        this.imageFileName = imageFileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }
}

