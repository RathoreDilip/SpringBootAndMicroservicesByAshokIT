package com.ashokit.controller;

import com.ashokit.entity.Student;
import com.ashokit.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    // this method and below method is same
//    @GetMapping("/student")
//    public String loadForm(Model model) {
//        model.addAttribute("msg","hi");
//        return "index";
//    }

    // method to display empty form
    @GetMapping("/")
    public ModelAndView indexPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    // method to save student form data
    @PostMapping("/saveStudent")
    public ModelAndView handleSubmitBtn(Student student){
        ModelAndView modelAndView=new ModelAndView();

        boolean isSaved = studentService.saveStudent(student);

        if (isSaved)
            modelAndView.addObject("smsg","Student Saved");
        else
            modelAndView.addObject("emsg","Failed to Save");

        modelAndView.setViewName("index");

        return modelAndView;
    }

    // method to get all student data
    @GetMapping("/getData")
    public ModelAndView getAllStudents(){
        ModelAndView modelAndView=new ModelAndView();

        List<Student> studentList = studentService.getAllStudent();

        System.out.println("studentList :: "+studentList);

        modelAndView.addObject("students",studentList);

        modelAndView.setViewName("studentsData");

        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView deleteStudent(@RequestParam("student_id") Integer student_id){
        ModelAndView modelAndView=new ModelAndView();

        studentService.delete(student_id);

        List<Student> studentList = studentService.getAllStudent();

        System.out.println("studentList :: "+studentList);

        modelAndView.addObject("students",studentList);

        modelAndView.setViewName("studentsData");

        return modelAndView;
    }

}
