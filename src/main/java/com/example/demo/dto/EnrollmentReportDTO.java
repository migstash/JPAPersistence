package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class EnrollmentReportDTO {

    private Integer enrollmentID;
    private List<SubjectDTO> subjectDTOList;
}
