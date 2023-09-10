package com.example.backend.controller;

import com.example.library.annotation.classes.ApiController;
import com.example.library.annotation.method.ApiPostMapping;
import org.springframework.http.ResponseEntity;

@ApiController
public class Test {

    @ApiPostMapping
    public ResponseEntity<String> test2() {
        return ResponseEntity.ok("Hello");
    }
}
