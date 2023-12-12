package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="enrollment", schema = "school")
@Data
@NoArgsConstructor
public class Enrollment {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="native")
    @GenericGenerator(name = "native")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Student student;

    @ManyToOne
    private Subject subject;

    @Column(name="status", length=20, nullable = false)
    private String status;

    public Enrollment(Student student, Subject subject, String status) {
        this.student = student;
        this.subject = subject;
        this.status = status;
    }
}
