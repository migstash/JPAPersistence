package com.example.demo.controller;

import com.example.demo.dto.SubjectDTO;
import com.example.demo.entity.Subject;
import com.example.demo.repository.SubjectRepository;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subjects")
public class SubjectsController {

    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping("/getAll")
    public @ResponseBody String getAllSubjects() {
        return subjectRepository.findAll().toString();
    }

    @GetMapping("/getSubject/{id}")
    public @ResponseBody String getSubjectById(@PathVariable Integer id) {
        return subjectRepository.findById(id).toString();
    }

    @GetMapping("/findByListId")
    public @ResponseBody String findByListId(@RequestBody List<Integer> idList) {
        return subjectRepository.findAllDistinctByIdList(idList).toString();
    }

    @PostMapping("/addSubject")
    public @ResponseBody String addSubjects(@RequestBody SubjectDTO payload) {
        try {
            return "added subject: " + subjectRepository.save(new Subject(payload));
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

}
