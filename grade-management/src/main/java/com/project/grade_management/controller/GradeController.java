package com.project.grade_management.controller;

import com.project.grade_management.model.Grade;
import com.project.grade_management.model.User;
import com.project.grade_management.repository.UserRepository;
import com.project.grade_management.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;
    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<Grade>> getGrades(Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<Grade> grades = gradeService.getGradesForUser(user);
        return ResponseEntity.ok(grades);
    }

    @GetMapping("/{id}")
    public Grade getGrade(@PathVariable Long id) {
        return gradeService.getGradeById(id).orElse(null);
    }

    @PostMapping
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeService.saveGrade(grade);
    }

    @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable Long id) {
        gradeService.deleteGrade(id);
    }



}
