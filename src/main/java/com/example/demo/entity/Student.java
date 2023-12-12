package com.example.demo.entity;

import com.example.demo.dto.StudentDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="student", schema = "school")
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="native")
    @GenericGenerator(name = "native")
    private Integer id;

    @Column(name="first_name", length=100, nullable = false)
    private String firstName;

    @Column(name="last_name", length=100, nullable = false)
    private String lastName;

    public Student(StudentDTO student) {
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
    }

    public String getWholeName() {
        return this.firstName + " " + this.lastName;
    }
}
