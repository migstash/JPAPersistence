package com.example.demo.dto;

import com.example.demo.entity.Subject;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubjectDTO {
//    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;
    private String name;
    private Double units;

    public SubjectDTO(Subject subject) {
        this.name = subject.getName();
        this.units = subject.getUnits();
    }
}
