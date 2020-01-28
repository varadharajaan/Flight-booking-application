package com.invia.flightticketbooking.repository;

import com.invia.flightticketbooking.model.Airport;
import com.invia.flightticketbooking.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

    @Query("SELECT u FROM Flight u WHERE (u.departureAirport in :depAirport AND (u.destinationAirport in :destAirport AND u.departureDate >= :depDate))")
    List<Flight> findAllByDepartureAirportEqualsAndDestinationAirportEqualsAndDepartureDateEquals
            (Airport depAirport, Airport destAirport, LocalDate depDate);

}
