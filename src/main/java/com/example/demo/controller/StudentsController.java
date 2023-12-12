package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@Slf4j
public class StudentsController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/getAll")
    public @ResponseBody String getAllStudents() {
        return studentRepository.findAll().toString();
    }

    @GetMapping("/getStudent/{id}")
    public @ResponseBody String getAllStudents(@PathVariable Integer id) {
        return studentRepository.findById(id).toString();
    }

    @PostMapping("/addStudent")
    public @ResponseBody String enrollStudent(@RequestBody StudentDTO payload) {
        try {
            return "added student: " + studentRepository.save(new Student(payload));
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

}
