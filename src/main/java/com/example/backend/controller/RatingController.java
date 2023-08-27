package com.example.backend.controller;

import com.example.backend.model.Rating;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("rating")
public class RatingController {

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody Rating rating) {

        rating.dateRating = LocalDate.now().toString();

        return ResponseEntity.ok(rating);
    }
}
