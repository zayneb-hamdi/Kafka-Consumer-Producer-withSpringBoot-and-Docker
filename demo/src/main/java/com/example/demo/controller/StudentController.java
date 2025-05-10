package com.example.demo.controller;

import com.example.demo.Model.Bonus;
import com.example.demo.Model.Student;
import com.example.demo.Service.BonusService;
import com.example.demo.Service.StudentService;
import com.example.demo.repository.BonusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/allstudents")
    public List<Student> getStudents()
    {
        return studentService.getStudent();
    }
    @PostMapping("/addstudent")
    public void addStudent(@RequestBody Student student)
    {
        studentService.addNewStudent(student);
    }

}
