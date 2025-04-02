package com.project.grade_management.service;

import com.project.grade_management.model.Grade;
import com.project.grade_management.model.User;
import com.project.grade_management.repository.GradeRepository;
import com.project.grade_management.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final GradeRepository gradeRepository;

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Optional<Grade> getGradeById(Long id) {
        return gradeRepository.findById(id);
    }

    public Grade saveGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
    public List<Grade> getGradesForUser(User user) {
        if (user.getRole() == Role.TEACHER) {
            return gradeRepository.findAll();
        } else {
            return gradeRepository.findByStudent_Email(user.getEmail());
        }
    }

}
