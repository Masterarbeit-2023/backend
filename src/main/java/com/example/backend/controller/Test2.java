package com.example.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/Test")
public class Test2 {


    @PostMapping
    public ResponseEntity<String> test2() {
        return ResponseEntity.ok("Hello");
    }

    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Test");
    }

    public static void test() {

    }
}
