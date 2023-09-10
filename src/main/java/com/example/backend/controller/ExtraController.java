package com.example.backend.controller;

import com.example.backend.model.Extra;
import com.example.backend.repository.ExtraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/extras")
public class ExtraController {

    @Autowired
    private ExtraRepository extraRepository;

    @GetMapping
    public ResponseEntity<List<Extra>> getExtras() {
        List<Extra> result = new ArrayList<>();
        extraRepository.findAll().forEach(result::add);
        return ResponseEntity.ok(result);
    }
}
