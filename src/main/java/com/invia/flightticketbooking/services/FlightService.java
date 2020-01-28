package com.invia.flightticketbooking.services;

import com.invia.flightticketbooking.model.Airport;
import com.invia.flightticketbooking.model.Flight;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface FlightService {
    public abstract Page<Flight> getAllFlightsPaged(int pageNum);
    public abstract List<Flight> getAllFlights();
    public abstract Flight getFlightById(int flightId);
    public abstract Flight saveFlight(Flight flight);
    public abstract void deleteFlightById(int flightId);
    public abstract List<Flight> getAllFlightsByAirportAndDepartureTime(Airport depAirport, Airport destAirport, LocalDate depDate);
}
