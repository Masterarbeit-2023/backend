package com.example.backend.controller;

import com.example.backend.dto.RoomDto;
import com.example.backend.model.Facility;
import com.example.backend.model.Rate;
import com.example.backend.model.Room;
import com.example.backend.repository.FacilityRepository;
import com.example.backend.repository.RateRepository;
import com.example.backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    @GetMapping
    public ResponseEntity<List<RoomDto>> getRooms() {
        List<Room> rooms = new ArrayList<Room>();
        roomRepository.findAll().forEach(rooms::add);

        List<RoomDto> roomDtos = new ArrayList<>();

        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            roomDtos.add(
                    new RoomDto(
                            room.id,
                            room.name,
                            new Facility[]{facilityRepository.findAll().iterator().next()},
                            new Rate[]{rateRepository.findAll().iterator().next()},
                            room.numberOfPersons,
                            room.roomSizeInSqm
                    )
            );
        }
        return ResponseEntity.ok(roomDtos);
        /*
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
                                        )},
                                2,
                                19
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
                                        )},
                                2,
                                19
                        )
                }
        ));
         */
    }

    @GetMapping("getAvailableRooms")
    public ResponseEntity<List<RoomDto>> getAvailableRooms(
            @RequestParam(required = false) Long hotelId,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) int adults,
            @RequestParam(required = false) int children,
            @RequestParam(required = false) boolean petsAllowed
    ) {

        List<Room> rooms = new ArrayList<>();
        roomRepository.findRoomsByNumberOfPersonsGreaterThanEqualAndPetsAllowed(adults + children, petsAllowed).forEach(rooms::add);

        List<RoomDto> roomDtos = new ArrayList<>();

        for (Room room : rooms) {
            roomDtos.add(
                    new RoomDto(
                            room.id,
                            room.name,
                            new Facility[]{facilityRepository.findAll().iterator().next()},
                            new Rate[]{rateRepository.findAll().iterator().next()},
                            room.numberOfPersons,
                            room.roomSizeInSqm
                    )
            );
        }
        return ResponseEntity.ok(roomDtos);
    }

    @PutMapping("block/{id}")
    public ResponseEntity<Room> blockRoom(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(new Room(
                "Doppel-Zimmer",
                new Facility[]{new Facility("21m²"), new Facility("Klimaanlage")},
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
                        )},
                2,
                19,
                false
        ));
    }
}
