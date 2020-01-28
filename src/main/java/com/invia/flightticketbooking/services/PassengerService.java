package com.invia.flightticketbooking.services;

import com.invia.flightticketbooking.model.Passenger;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PassengerService {
    public abstract Page<Passenger> getAllPassengersPaged(int pageNum);
    public abstract List<Passenger> getAllPassengers();
    public abstract Passenger getPassengerById(String passengerId);
    public abstract Passenger savePassenger(Passenger passenger);
    public abstract void deletePassengerById(String passengerId);
}
