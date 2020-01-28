package com.invia.flightticketbooking.repository;

import com.invia.flightticketbooking.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {
}
