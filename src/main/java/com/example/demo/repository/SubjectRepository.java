package com.example.demo.repository;

import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    @Query(value="SELECT DISTINCT s FROM Subject s WHERE s.id IN (:subjectList)")
    List<Subject> findAllDistinctByIdList(@Param("subjectList") List<Integer> subjectList);
}
