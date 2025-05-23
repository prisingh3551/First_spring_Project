package com.priya.First_spring_Project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.priya.First_spring_Project.entities.Student;
import com.priya.First_spring_Project.service.StudentService;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService service) {
        this.studentService = service;
    }

    @PostMapping("/student/add")
    public Student addStudent(@RequestBody Student student) {
        return this.studentService.addStudent(student);
    }

    @GetMapping("/student/{sId}")  // studentid is taken from url
    public Student getStudentById(@PathVariable(name = "sId") long studentId) {
        return this.studentService.getStudentById(studentId);
    }

    @PutMapping("/student/{studentId}")
    public Student updateStudent(@PathVariable long studentId, @RequestBody Student student) {
        if(studentId != student.getId()) {
            // throw some error
        }
        return this.studentService.updateStudent(student);
    }

    @DeleteMapping("/student/{studentId}")
    public void deleteStudent(@PathVariable long studentId) {
        this.studentService.deleteStudentById(studentId);
    }
}
