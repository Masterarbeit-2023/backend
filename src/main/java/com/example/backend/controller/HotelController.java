package com.example.backend.controller;

import com.example.backend.model.Address;
import com.example.backend.model.Hotel;
import com.example.backend.model.Rating;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/hotels")
public class HotelController {

    @GetMapping()
    public ResponseEntity<List<Hotel>> get(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) int adults,
            @RequestParam(required = false) int children,
            @RequestParam(required = false) int rooms,
            @RequestParam(required = false) boolean petsAllowed
    ) {
        Hotel hotel = new Hotel(
                "Testhotel",
                "15:00",
                "12:00",
                new Address("Holzhude", 2, "21029", "Hamburg", "Deutschland"),
                new Rating(8.1f, 8, 7, 8, 8, 8, 8, 8, 8, 8, 6),
                new Rating[]{new Rating(8.1f, 8, 7, 8, 8, 8, 8, 8, 8, 8, 6, "Das Hotel ist gut! Laesst keine Wuensche offen ausser - ab 11 pm nur Oeffnung ueber Sekurity! Das parkhaus ist leider sehr schlecht ausgeschildert - nach 10pm kann man sich verlaufen - wir haben 30 Minuten gebraucht und Hilfe benoetigt! Ohne Auto ok - mit Auto fier mich nicht mehr!", "Wilhelm", "25.02.2023")},
                140,
                1.9f,
                new String[]{ "kostenlose Stornierung", "Frühstück inklusive" },
                new String[]{ "Balkon" }
        );
        return ResponseEntity.ok(List.of(hotel));
    }
}
