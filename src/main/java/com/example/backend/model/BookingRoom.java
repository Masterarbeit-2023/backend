package com.example.backend.model;

import com.example.backend.dto.RoomDto;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class BookingRoom extends BaseModel{
    RoomDto room;
    Rate rate;
}
