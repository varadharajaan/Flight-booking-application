package com.invia.flightticketbooking.services;

import com.invia.flightticketbooking.model.Aircraft;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface AircraftService {
    public abstract Page<Aircraft> getAllAircraftsPaged(int pageNum);
    public abstract List<Aircraft> getAllAircrafts();
    public abstract Aircraft getAircraftById(int aircraftId);
    public abstract Aircraft saveAircraft(Aircraft aircraft);
    public abstract void deleteAircraftById(int aircraftId);
}
