package com.example.demo.dto;

import lombok.Data;

@Data
public class EnrollmentDTO {
    private Integer id;
    private Integer studentId;
    private Integer subjectId;
    private String status;
}
