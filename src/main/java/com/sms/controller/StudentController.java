package com.sms.controller;

import com.sms.entity.Student;
import com.sms.entity.StudentDto;
import com.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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


//        // save image file
//        MultipartFile image = studentDto.getImageFileName();
//        Date createdAt = new Date();
//        String storageFileName = createdAt.getTime() + "_" + image.getOriginalFilename();
//
//        try {
//            String uploadDir = "public/images/";
//            Path uploadPath = Paths.get(uploadDir);
//
//            if (!Files.exists(uploadPath)) {
//                Files.createDirectories(uploadPath);
//            }
//
//            try (InputStream inputStream = image.getInputStream()) {
//                Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
//                        StandardCopyOption.REPLACE_EXISTING);
//            }
//        } catch (Exception ex) {
//            System.out.println("Exception: " + ex.getMessage());
//        }
//
//
//        Student student = new Student();
//        student.setFirstName(studentDto.getFirstName());
//        student.setLastName(studentDto.getLastName());
//        student.setSubject(studentDto.getSubject());
//        student.setGrade(studentDto.getGrade());
//        student.setImageFileName(storageFileName);
//
//        repository.save(student);


        return "redirect:/products";
    }

}


