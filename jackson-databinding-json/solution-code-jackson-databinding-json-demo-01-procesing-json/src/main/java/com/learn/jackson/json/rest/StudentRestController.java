package com.learn.jackson.json.rest;

import com.learn.jackson.json.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> studentList;

    @PostConstruct
    public void loadData() {
        studentList = new ArrayList<>();
        studentList.add(new Student("JK", "Jeon"));
        studentList.add(new Student("KTH", "Kim"));
        studentList.add(new Student("Jin", "Kim"));

    }

    @GetMapping("/students")
    public List<Student> getStudent(){
        return studentList;
    }
    @GetMapping("students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if(studentId <0 || studentId>studentList.size())
            throw new StudentNotFoundException("Invalid StudentId - "+studentId);
        return studentList.get(studentId);
    }


}
