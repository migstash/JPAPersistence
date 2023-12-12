package com.example.demo.service;

import com.example.demo.dto.ReportDTO;
import com.example.demo.entity.Enrollment;
import com.example.demo.entity.Student;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GenericSchoolMapper genericSchoolMapper;

    public ReportDTO getReportByStudentId(Integer studentId) throws Exception {
        try {

            List<Enrollment> enrollmentList = enrollmentRepository.findByStudentId(studentId);
            if (CollectionUtils.isEmpty(enrollmentList)) {
                throw new RuntimeException("Enrollment records not found for student: " + studentId);
            } else {
                return genericSchoolMapper.mapEnrollmentListToReportDTO(enrollmentList);
            }
        }
        catch (Exception e) {
            throw e;
        }
    }
}
