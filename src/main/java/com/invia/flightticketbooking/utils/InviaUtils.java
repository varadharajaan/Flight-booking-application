package com.invia.flightticketbooking.utils;


import com.invia.flightticketbooking.constants.InviaConstants;
import com.invia.flightticketbooking.model.Aircraft;
import com.invia.flightticketbooking.model.Airport;
import com.invia.flightticketbooking.model.Flight;
import com.invia.flightticketbooking.model.Passenger;
import com.invia.flightticketbooking.services.AircraftService;
import com.invia.flightticketbooking.services.AirportService;
import com.invia.flightticketbooking.services.FlightService;
import com.invia.flightticketbooking.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.invia.flightticketbooking.constants.InviaConstants.*;


@Component
public class InviaUtils {

    @Autowired
    AirportService airportService;
    @Autowired
    AircraftService aircraftService;
    @Autowired
    FlightService flightService;
    @Autowired
    PassengerService passengerService;

    public String saveAirport(@ModelAttribute("airport") @Valid Airport airport, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(InviaConstants.errors, bindingResult.getAllErrors());
            model.addAttribute("airport", new Airport());
            return newAirport;
        }
        airportService.saveAirport(airport);
        model.addAttribute(aircrafts, airportService.getAllAirportsPaged(0));
        model.addAttribute(currentPage, 0);
        return airports;
    }

    public String deleteAirport( long airportId, Model model) {
        airportService.deleteAirport(airportId);
        model.addAttribute(airports, airportService.getAllAirportsPaged(0));
        model.addAttribute(InviaConstants.currentPage, 0);
        return airports;
    }

    public String showAirportsList( int pageNo, Model model) {
        model.addAttribute(airports, airportService.getAllAirportsPaged(pageNo));
        model.addAttribute("currentPage", pageNo);
        return airports;
    }

    public String showAircraftPage(Model model) {
        model.addAttribute("aircraft", new Aircraft());
        return "newAircraft";
    }

    public String saveAircraft(@ModelAttribute("aircraft") @Valid Aircraft aircraft, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("aircraft", new Aircraft());
            return "newAircraft";
        }
        aircraftService.saveAircraft(aircraft);
        model.addAttribute(InviaConstants.aircrafts, aircraftService.getAllAircraftsPaged(0));
        model.addAttribute(InviaConstants.currentPage, 0);
        return InviaConstants.aircrafts;
    }

    public String showAircracftList( int pageNo, Model model) {
        model.addAttribute(InviaConstants.aircrafts, aircraftService.getAllAircraftsPaged(pageNo));
        model.addAttribute(InviaConstants.currentPage, pageNo);
        return InviaConstants.aircrafts;
    }

    public String saveFlight(@ModelAttribute(InviaConstants.flight) @Valid Flight flight, BindingResult bindingResult, int departureAirport, int destinationAirport, int aircraftId,  String arrivalTime,  String departureTime, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute(InviaConstants.flight, new Flight());
            model.addAttribute(InviaConstants.aircrafts, aircraftService.getAllAircrafts());
            model.addAttribute(InviaConstants.airports, airportService.getAllAirports());
            return "newFlight";
        }
        if (departureAirport == destinationAirport) {
            model.addAttribute("sameAirportError", "Departure and destination airport can't be same");
            model.addAttribute(InviaConstants.flight, new Flight());
            model.addAttribute(InviaConstants.aircrafts, aircraftService.getAllAircrafts());
            model.addAttribute(InviaConstants.airports, airportService.getAllAirports());
            return "newFlight";
        }

        flight.setAircraft(aircraftService.getAircraftById(aircraftId));
        flight.setDepartureAirport(airportService.getAirportById(departureAirport));
        flight.setDestinationAirport(airportService.getAirportById(destinationAirport));
        flight.setDepartureTime(departureTime);
        flight.setArrivalTime(arrivalTime);
        flightService.saveFlight(flight);

        model.addAttribute(flights, flightService.getAllFlightsPaged(0));
        model.addAttribute(currentPage, 0);
        return flights;
    }

    public String deleteFilght( int flightId, Model model) {
        flightService.deleteFlightById(flightId);
        model.addAttribute(flights, flightService.getAllFlightsPaged(0));
        model.addAttribute(currentPage, 0);
        return flights;
    }

    public String showNewFlightPage(Model model) {
        model.addAttribute(InviaConstants.flight, new Flight());
        model.addAttribute(InviaConstants.aircrafts, aircraftService.getAllAircrafts());
        model.addAttribute(InviaConstants.airports, airportService.getAllAirports());
        return InviaConstants.newFlight;
    }

    public String showFlightsList(int pageNo, Model model) {
        model.addAttribute(flights, flightService.getAllFlightsPaged(pageNo));
        model.addAttribute("currentPage", pageNo);
        return flights;
    }

    public String showSearchFlightPage(Model model) {
        model.addAttribute(InviaConstants.airports, airportService.getAllAirports());
        model.addAttribute(flights, null);
        return searchFlight;
    }

    public String searchFlight(@RequestParam("departureAirport") int departureAirport, @RequestParam("destinationAirport") int destinationAirport, @RequestParam("departureTime") String departureTime, Model model) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate deptTime = LocalDate.parse(departureTime, dtf);
        Airport depAirport = airportService.getAirportById(departureAirport);
        Airport destAirport = airportService.getAirportById(destinationAirport);

        if (departureAirport == destinationAirport) {
            model.addAttribute("AirportError", "Departure and destination airport cant be same!");
            model.addAttribute(InviaConstants.airports, airportService.getAllAirports());
            return searchFlight;
        }
        List<Flight> flights = flightService.getAllFlightsByAirportAndDepartureTime(depAirport, destAirport, deptTime);
        if(flights.isEmpty()){
            model.addAttribute(notFound, "No Record Found!");
        }else{
            model.addAttribute("flights", flights);
        }

        model.addAttribute(InviaConstants.airports, airportService.getAllAirports());
        return "searchFlight";
    }

    public String showBookFlightPage(Model model) {
        model.addAttribute(InviaConstants.airports, airportService.getAllAirports());

        return bookFlight;
    }

    public String searchFlightToBook(@RequestParam("departureAirport") int departureAirport, @RequestParam("destinationAirport") int destinationAirport, @RequestParam("departureTime") String departureTime, Model model) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate deptTime = LocalDate.parse(departureTime, dtf);
        Airport depAirport = airportService.getAirportById(departureAirport);
        Airport destAirport = airportService.getAirportById(destinationAirport);

        if (departureAirport == destinationAirport) {
            model.addAttribute("AirportError", "Departure and destination airport cant be same!");
            model.addAttribute(InviaConstants.airports, airportService.getAllAirports());
            return "bookFlight";
        }
        List<Flight> flights = flightService.getAllFlightsByAirportAndDepartureTime(depAirport, destAirport, deptTime);
        if(flights.isEmpty()){
            model.addAttribute(notFound, "No Record Found!");
        }else{
            model.addAttribute("flights", flights);
        }
        model.addAttribute(InviaConstants.airports, airportService.getAllAirports());
        return "bookFlight";
    }


    public String cancelTicket(@RequestParam("passengerId") String passengerId, Model model) {
        passengerService.deletePassengerById(passengerId);
        model.addAttribute(flights, flightService.getAllFlightsPaged(0));
        model.addAttribute(currentPage, 0);
        return flights;
    }
    public String showPassengerList(@RequestParam int flightId, Model model) {
        List<Passenger> passengers = flightService.getFlightById(flightId).getPassengers();
        model.addAttribute(InviaConstants.passengers, passengers);
        model.addAttribute(InviaConstants.flight, flightService.getFlightById(flightId));
        return "passengers";
    }

    public String showVerifyBookingPageResult(@RequestParam("flightId") int flightId, @RequestParam("passengerId") String passengerId, Model model) {
        Flight flight = flightService.getFlightById(flightId);
        if (flight != null) {
            model.addAttribute(InviaConstants.flight, flight);
            List<Passenger> passengers = flight.getPassengers();
            Passenger passenger = null;
            for (Passenger p : passengers) {
                if (p.getPassengerId().equals(passengerId)) {
                    passenger = passengerService.getPassengerById(passengerId);
                    model.addAttribute("passenger", passenger);
                }
            }
            if (passenger != null) {
                return verifyBooking;
            }else{
                model.addAttribute(notFound, "Not Found");
                return verifyBooking;
            }
        } else {
            model.addAttribute(notFound, "Not Found");
            return verifyBooking;
        }
    }

    public String bookFlight(@ModelAttribute("passenger") @Valid Passenger passenger, @RequestParam("flightId") int flightId, Model model) {
        Flight flight = flightService.getFlightById(flightId);
        passenger.setFlight(flight);
        passengerService.savePassenger(passenger);
        model.addAttribute("passenger", passenger);
        return "confirmationPage";
    }




}
