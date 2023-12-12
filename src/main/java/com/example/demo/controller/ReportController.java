package com.example.demo.controller;

import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("report")
@Slf4j
public class ReportController {

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Autowired
    ReportService reportService;

    @GetMapping("/getReportByStudentId/{id}")
    public ResponseEntity<?> getReportByStudentId(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(reportService.getReportByStudentId(id));
    }

    @GetMapping("/getReportBySubjectId/{id}")
    public ResponseEntity<?> getReportBySubjectId(@PathVariable Integer id) {
        return ResponseEntity.ok(enrollmentRepository.findBySubjectId(id));
    }
}
