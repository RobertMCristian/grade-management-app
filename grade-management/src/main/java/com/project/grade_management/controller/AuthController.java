package com.project.grade_management.controller;

import com.project.grade_management.auth.AuthRequest;
import com.project.grade_management.auth.AuthResponse;
import com.project.grade_management.auth.AuthService;
import com.project.grade_management.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.project.grade_management.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody User user) {
        System.out.println("REGISTER HIT!!!");
        String token = authService.register(user);
        return new AuthResponse(token);
    }


    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        String token = authService.login(request);
        return new AuthResponse(token);
    }
    @GetMapping("/me")
    public ResponseEntity<User> me(Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        user.setPassword(null);
        return ResponseEntity.ok(user);
    }

}
