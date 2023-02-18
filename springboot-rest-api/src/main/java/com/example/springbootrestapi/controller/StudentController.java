package com.example.springbootrestapi.controller;

import com.example.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("students/{id}")
    public Student getStudent(@PathVariable int id){
        return new Student(id,"Mohan", "R");
    }
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student getStudentWithMultiplePathVariable(@PathVariable int id, @PathVariable("first-name") String firstName,
                              @PathVariable("last-name") String lastName){
        return new Student(id,firstName, lastName);
    }

    //http://localhost:8080/students/query?id=1
    @GetMapping("students/query")
    public Student StudentWithRequestParam(@RequestParam int id){
        return new Student(id,"Mohan", "R");
    }

    //http://localhost:8080/students/queryMultiple?id=1&firstName=Siva&lastName=Karthikeyan
    @GetMapping("students/queryMultiple")
    public Student StudentWithMultipleRequestParam(@RequestParam int id, @RequestParam String firstName,
                                                   @RequestParam String lastName){
        return new Student(id,firstName, lastName);
    }

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
}
