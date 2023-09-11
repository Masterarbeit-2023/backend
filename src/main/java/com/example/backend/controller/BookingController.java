package com.example.backend.controller;

import com.example.backend.dto.BookingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/booking")
public class BookingController {

    @PostMapping
    public ResponseEntity<BookingDto> bookVisit(@RequestBody BookingDto booking) {
        return ResponseEntity.ok(booking);
    }
}
