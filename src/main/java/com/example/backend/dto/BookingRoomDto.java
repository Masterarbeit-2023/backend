package com.example.backend.dto;

public class BookingRoomDto {
    public Long room;
    public Long rate;

    public BookingRoomDto(Long room, Long rate) {
        this.room = room;
        this.rate = rate;
    }
}
