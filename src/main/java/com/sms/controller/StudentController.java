package com.sms.controller;

import com.sms.entity.Student;
import com.sms.entity.StudentDto;
import com.sms.repositoryservice.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.*;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @GetMapping({"", "/"})
    public String showStudentList(Model model) {
        List<Student> students = repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("students", students);
        return "students/index";
    }

    @GetMapping("/create")
    public String showcreateStudentPage(Model model) {
        StudentDto studentDto = new StudentDto();
        model.addAttribute("studentDto", studentDto);
        return "students/create_student";
    }

    @PostMapping("/create")
    public String createStudent(
            @Valid @ModelAttribute StudentDto studentDto,
            BindingResult result
    ) {

        if (studentDto.getImageFileName().isEmpty()) {
            result.addError(new FieldError("studentDto", "imageFileName", "The image file is required"));
        }


        if (result.hasErrors()) {
            return "students/create_student";
        }


        // save image file
        MultipartFile image = studentDto.getImageFileName();
        Date createdAt = new Date();
        String storageFileName = createdAt.getTime() + "_" + image.getOriginalFilename();

        try {
            String uploadDir = "public/images/";
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            try (InputStream inputStream = image.getInputStream()) {
                Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }


        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setSubject(studentDto.getSubject());
        student.setGrade(studentDto.getGrade());
        student.setCreatedAt(createdAt);
        student.setImageFileName(storageFileName);

        repository.save(student);


        return "redirect:/students";
    }

    @GetMapping("/edit")
    public String showEditPage(Model model,
                               @RequestParam int id) {

        try {
            Student student = repository.findById(id).get();
            model.addAttribute("student", student);

            StudentDto studentDto = new StudentDto();
            studentDto.setFirstName(student.getFirstName());
            studentDto.setLastName(student.getLastName());
            studentDto.setSubject(student.getSubject());
            studentDto.setGrade(student.getGrade());

            model.addAttribute("studentDto", studentDto);
        }
        catch(Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            return "redirect:/students";
        }

        return "students/edit_student";
    }

    @PostMapping("/edit")
    public String updateStudent(Model model,
                                @RequestParam int id,
                                @Valid @ModelAttribute StudentDto studentDto,
                                BindingResult result) {

        try {
            Student student = repository.findById(id).get();
            model.addAttribute("student", student);

            if (result.hasErrors()) {
                return "students/edit_student";
            }

            if (!studentDto.getImageFileName().isEmpty()) {
                // delete old image
                String uploadDir = "public/images/";
                Path oldImagePath = Paths.get(uploadDir + student.getImageFileName());

                try {
                    Files.delete(oldImagePath);
                }
                catch(Exception ex) {
                    System.out.println("Exception: " + ex.getMessage());
                }

                // save new image file
                MultipartFile image = studentDto.getImageFileName();
                Date createdAt = new Date();
                String storageFileName = createdAt.getTime() + "_" + image.getOriginalFilename();

                try (InputStream inputStream = image.getInputStream()) {
                    Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
                            StandardCopyOption.REPLACE_EXISTING);
                }

                student.setImageFileName(storageFileName);
            }

            student.setFirstName(studentDto.getFirstName());
            student.setLastName(studentDto.getLastName());
            student.setSubject(studentDto.getSubject());
            student.setGrade(studentDto.getGrade());

            repository.save(student);
        }
        catch(Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

        return "redirect:/students";
    }

}


