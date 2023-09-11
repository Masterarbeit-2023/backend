package com.example.backend.dto;

import com.example.backend.model.Extra;
import lombok.Data;

@Data
public class BookingDto {
    Long id;
    String startDate;
    String endDate;
    int adults;
    int children;
    Extra[] extras;
    BookingRoomDto[] rooms;

    public BookingDto(){}

    public BookingDto(Long id, String startDate, String endDate, int adults, int children, Extra[] extras, BookingRoomDto[] rooms) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.adults = adults;
        this.children = children;
        this.extras = extras;
        this.rooms = rooms;
    }
}
