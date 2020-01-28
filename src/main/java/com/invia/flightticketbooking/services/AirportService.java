package com.invia.flightticketbooking.services;

import com.invia.flightticketbooking.model.Airport;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface AirportService {
    public abstract Page<Airport> getAllAirportsPaged(int pageNum);
    public abstract List<Airport> getAllAirports();
    public abstract Airport getAirportById(long airportId);
    public abstract Airport saveAirport(Airport airport);
    public abstract void deleteAirport(long airpportId);
}
