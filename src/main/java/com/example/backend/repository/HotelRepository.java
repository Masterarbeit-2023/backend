package com.example.backend.repository;

import com.example.backend.model.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, Long> {
}
