package com.sms.entity;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "subject")
    private String subject;
    @Column(name = "email")
    private String email;
    @Column(name = "behaviour")
    private String behaviour;

    @Lob
    @Column(name = "imageFileName", columnDefinition = "BLOB")
    private byte imageFileName;

    public Student() {
    }

    public Student(String firstName, String lastName, String subject, String email, String behaviour, byte imageFileName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        this.email = email;
        this.behaviour = behaviour;
        this.imageFileName = imageFileName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    public byte getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(byte imageFileName) {
        this.imageFileName = imageFileName;
    }
}


