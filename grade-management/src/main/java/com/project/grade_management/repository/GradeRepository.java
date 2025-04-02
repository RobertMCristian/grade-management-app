package com.project.grade_management.repository;

import com.project.grade_management.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByStudentId(Long studentId);
    List<Grade> findByAssignmentId(Long assignmentId);
    List<Grade> findByStudent_Email(String email);
}
