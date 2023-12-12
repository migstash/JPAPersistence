package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class EnrollSubjectsDTO {
    private Integer studentId;
    private List<Integer> subjectList;
}
