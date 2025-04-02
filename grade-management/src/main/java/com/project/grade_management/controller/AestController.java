package com.project.grade_management.controller;

import com.project.grade_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/test")
public class AestController {

    private final UserService userService;

    @GetMapping
    public String test() {
        return "merge!";
    }
}
