package com.sms.service;

import com.sms.entity.Student;

import java.util.List;


public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent (Student student);
}
