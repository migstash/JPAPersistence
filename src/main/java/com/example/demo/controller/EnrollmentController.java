package com.example.demo.controller;

import com.example.demo.dto.EnrollSubjectsDTO;
import com.example.demo.entity.Enrollment;
import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.SubjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("enrollment")
@Slf4j
public class EnrollmentController {

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @PostMapping("/enrollSubjects")
    public @ResponseBody String enrollSubjectsByStudent(@RequestBody EnrollSubjectsDTO enrollSubjectsDTO) {
        try {
            if(!Objects.isNull(enrollSubjectsDTO) && !CollectionUtils.isEmpty(enrollSubjectsDTO.getSubjectList())
                    || !Objects.isNull(enrollSubjectsDTO) && !Objects.isNull(enrollSubjectsDTO.getStudentId())
                    && enrollSubjectsDTO.getStudentId() > 0) {
                Optional<Student> student = studentRepository.findById(enrollSubjectsDTO.getStudentId());
                if (Objects.isNull(student.get())) {
                    return "student not found " + enrollSubjectsDTO.getStudentId();
                }
                List<Subject> subjectList = subjectRepository.findAllDistinctByIdList(enrollSubjectsDTO.getSubjectList());
                if (!CollectionUtils.isEmpty(subjectList)) {
                    for(Subject subject : subjectList) {
                        enrollmentRepository.save(new Enrollment(student.get(), subject, "NEW"));
                        log.info("enroll subject to student: " + student + " subject: " + subject);
                    }
                    return "enrollment done for student: " + student.get().getWholeName();
                } else {
                    return "subjects not found: " + subjectList;
                }
            } else {
                return "subjects/student ID cannot be null.";
            }

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
