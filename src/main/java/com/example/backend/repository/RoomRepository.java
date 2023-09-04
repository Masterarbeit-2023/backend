package com.example.backend.repository;

import com.example.backend.model.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long> {

    public Iterable<Room> findRoomsByNumberOfPersonsGreaterThanEqualAndPetsAllowed(int numberOfPersons, boolean petsAllowed);
}
