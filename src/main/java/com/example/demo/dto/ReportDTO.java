package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReportDTO {
    private Integer studentId;
    private String studentName;
    private List<SubjectDTO> subjectDTOList;
}
