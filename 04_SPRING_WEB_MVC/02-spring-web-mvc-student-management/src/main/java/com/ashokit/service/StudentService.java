package com.ashokit.service;

import com.ashokit.entity.Student;

import java.util.List;

public interface StudentService {

    public boolean saveStudent(Student student);

    public List<Student> getAllStudent();

    public void delete(Integer student_id);

}
