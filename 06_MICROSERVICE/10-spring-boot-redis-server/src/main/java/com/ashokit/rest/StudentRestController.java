package com.ashokit.rest;

import com.ashokit.entity.Student;
import com.ashokit.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/student")
    public String addStudent(@RequestBody Student student){
        studentRepository.save(student);
        return "Student Saved..";
    }

    @GetMapping("/student")
    public Iterable<Student> getStudents(){
        return studentRepository.findAll();
    }

}
