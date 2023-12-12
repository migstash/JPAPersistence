package com.example.demo.service;

import com.example.demo.dto.EnrollmentDTO;
import com.example.demo.dto.ReportDTO;
import com.example.demo.dto.SubjectDTO;
import com.example.demo.entity.Enrollment;
import com.example.demo.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenericSchoolMapper {

    public ReportDTO mapEnrollmentListToReportDTO(List<Enrollment> enrollmentList) {
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setStudentId(enrollmentList.get(0).getStudent().getId());
        reportDTO.setStudentName(enrollmentList.get(0).getStudent().getWholeName());
        reportDTO.setSubjectDTOList(enrollmentList.stream().map(enrollment ->
                mapSubjectToSubjectDTO(enrollment.getSubject())).collect(Collectors.toList()));
        return reportDTO;
    }
    public SubjectDTO mapSubjectToSubjectDTO(Subject subject) {
        return new SubjectDTO(subject);
    }

}
