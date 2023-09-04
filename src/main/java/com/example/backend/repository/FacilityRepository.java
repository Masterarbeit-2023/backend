package com.example.backend.repository;

import com.example.backend.model.Facility;
import org.springframework.data.repository.CrudRepository;

public interface FacilityRepository extends CrudRepository<Facility, Long> {
}
