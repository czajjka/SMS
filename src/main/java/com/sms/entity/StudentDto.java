package com.sms.entity;


import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;

public class StudentDto {
    @NotEmpty(message = "The name is required")
    private String firstName;

    @NotEmpty(message = "The name is required")
    private String lastName;

    @NotEmpty(message = "The subject is required")
    private String subject;

    @NotEmpty(message = "The grade is required")
    private Integer grade;

    private MultipartFile imageFileName;

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

    public MultipartFile getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(MultipartFile imageFileName) {
        this.imageFileName = imageFileName;
    }
}
