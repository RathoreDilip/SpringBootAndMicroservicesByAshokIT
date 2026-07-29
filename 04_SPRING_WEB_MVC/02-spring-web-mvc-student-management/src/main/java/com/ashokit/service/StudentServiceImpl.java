package com.ashokit.service;

import com.ashokit.entity.Student;
import com.ashokit.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    private EmailService emailService;

    public StudentServiceImpl(StudentRepository studentRepository,EmailService emailService){
        this.studentRepository=studentRepository;
        this.emailService=emailService;
    }

    @Override
    public boolean saveStudent(Student student) {
        Student saveStudent = studentRepository.save(student);

        String subject="Student Registration";
        String body="<h1>Your account created in ashokit website!</h1><br/><h2>Welcome to Ashok IT</h2>";

        //emailService.sendEmail(subject,body,student.getEmail());

        emailService.sendMimeMessageEmail(subject,body,student.getEmail());

        return saveStudent.getStudent_id()!=null;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void delete(Integer student_id) {
        studentRepository.deleteById(student_id);
    }
}
