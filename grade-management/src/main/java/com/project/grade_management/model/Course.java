package com.project.grade_management.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Profesorul care ține cursul
    @ManyToOne
    private User teacher;

    // Elevii înscriși
    @ManyToMany
    private List<User> students;
}