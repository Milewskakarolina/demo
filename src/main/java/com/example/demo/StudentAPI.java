package com.example.demo;

import org.springframework.web.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentAPI {

    private List<Student> studentList;

    public StudentAPI(){
        this.studentList = new ArrayList<>();
    }

    @PostMapping("/AddStudent")
    public boolean addStudent(@RequestBody Student student){
        return studentList.add(student);
    }

    @GetMapping("/studentList")
    public List<Student> getstudentList(){
        return studentList;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        return studentList.stream().filter(student -> student.getId()==id).findFirst().get();
    }

    @GetMapping("/name/{name}")
    public Student getStudentByName(@PathVariable String name){
        return studentList.stream().filter(student -> student.getName().equals(name)).findFirst().get();
    }

    @GetMapping("/delete/{id}")
    public boolean deleteStudentById(@PathVariable int id){
        Student stu =studentList.stream().filter(student -> student.getId()==id).findFirst().get();
        return studentList.remove(stu);
    }
}
