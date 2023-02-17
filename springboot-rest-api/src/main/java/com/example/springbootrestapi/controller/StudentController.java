package com.example.springbootrestapi.controller;

import com.example.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    //Path variable in a rest API
    //{id} URI template variable
    //http://localhost:8080/student/1
    @GetMapping("student/{id}")
    public Student getStudent(@PathVariable int id){
        return new Student(id,"Mohan", "R");
    }
    @GetMapping("student/{id}/{first-name}/{last-name}")
    public Student getStudentWithMultiplePathVariable(@PathVariable int id, @PathVariable("first-name") String firstName,
                              @PathVariable("last-name") String lastName){
        return new Student(id,firstName, lastName);
    }
}
