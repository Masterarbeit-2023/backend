package com.example.backend.controller;

import com.example.backend.model.User;
import com.example.backend.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        // Authenticate user (validate credentials)
        // Generate JWT token
        String token = generateJwtToken(user.email);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        // Check if user already exists


        return ResponseEntity.ok(user);
    }

    private String generateJwtToken(String email) {
        // Generate JWT token using a library like jjwt
        // Include user claims (e.g., email, roles)
        // Sign the token with a secret key
        return jwtUtils.generateJwtToken(email);
    }
}
