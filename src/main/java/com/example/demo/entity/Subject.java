package com.example.demo.entity;

import com.example.demo.dto.SubjectDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name="subject", schema = "school")
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="native")
    @GenericGenerator(name = "native")
    private Integer id;

    @Column(name="name", length=100, nullable = false)
    private String name;

    @Column(name="units", nullable = false)
    private Double units;

    public Subject(SubjectDTO subjectDTO) {
        this.name = subjectDTO.getName();
        this.units = subjectDTO.getUnits();
    }
}
