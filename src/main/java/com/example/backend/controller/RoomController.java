package com.example.backend.controller;

import com.example.backend.model.Rate;
import com.example.backend.model.Room;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/rooms")
public class RoomController {

    @GetMapping
    public ResponseEntity<List<Room>> getRooms() {
        return ResponseEntity.ok(List.of(
                new Room[]{
                        new Room(
                                "Standard-Zimmer",
                                new String[]{"21m²", "Klimaanlage"},
                                new Rate[]{
                                        new Rate(
                                                "Mitgliedsvorteil",
                                                true,
                                                new String[]{"Inklusive Frühstück", "Early Check-in"},
                                                230f
                                        ),
                                        new Rate(
                                                "Nicht-Stornierbar",
                                                false,
                                                new String[]{"Nicht-stornierbar", "Ohne Frühstück"},
                                                230f
                                        )}
                        ),
                        new Room(
                                "Doppel-Zimmer",
                                new String[]{"21m²", "Klimaanlage"},
                                new Rate[]{
                                        new Rate(
                                                "Mitgliedsvorteil",
                                                true,
                                                new String[]{"Inklusive Frühstück", "Early Check-in"},
                                                230f
                                        ),
                                        new Rate(
                                                "Nicht-Stornierbar",
                                                false,
                                                new String[]{"Nicht-stornierbar", "Ohne Frühstück"},
                                                230f
                                        )}

                        )
                }
        ));
    }
}
