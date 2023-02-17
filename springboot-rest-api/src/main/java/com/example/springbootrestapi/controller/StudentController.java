package com.example.springbootrestapi.controller;

import com.example.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("student")
    public Student createStudent(){
        Student student = new Student(1,"Mohan", "R");
        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1,"Mohan", "R"));
        students.add(new Student(2,"Bala", "JI"));
        students.add(new Student(3,"Raja", "Velu"));
        students.add(new Student(4,"Rajini", "Kanth"));
        students.add(new Student(5,"Siva", "karthikeyan"));
        return students;
    }
}
