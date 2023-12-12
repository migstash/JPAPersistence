package com.example.demo.repository;

import com.example.demo.entity.Enrollment;
import com.example.demo.entity.Subject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

    @Query("select asd from Enrollment inner join student")
    List<Enrollment> findByStudentId(Integer studentId);

    List<Enrollment> findBySubjectId(Integer subjectId);
}
