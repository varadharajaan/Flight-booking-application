package com.invia.flightticketbooking.controller;

import com.invia.flightticketbooking.constants.InviaConstants;
import com.invia.flightticketbooking.model.Aircraft;
import com.invia.flightticketbooking.model.Airport;
import com.invia.flightticketbooking.model.Flight;
import com.invia.flightticketbooking.model.Passenger;
import com.invia.flightticketbooking.services.AircraftService;
import com.invia.flightticketbooking.services.AirportService;
import com.invia.flightticketbooking.services.FlightService;
import com.invia.flightticketbooking.services.PassengerService;

import com.invia.flightticketbooking.utils.InviaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;


import static com.invia.flightticketbooking.constants.InviaConstants.*;

@Controller
public class MainController {

    @Autowired
    AirportService airportService;
    @Autowired
    AircraftService aircraftService;
    @Autowired
    FlightService flightService;
    @Autowired
    PassengerService passengerService;
    @Autowired
    InviaUtils inviaUtils;



    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/airport/new")
    public String showAddAirportPage(Model model) {
        model.addAttribute("airport", new Airport());
        return "newAirport";
    }

    @PostMapping("/airport/new")
    public String saveAirport(@Valid @ModelAttribute("airport") Airport airport, BindingResult bindingResult, Model model) {
        return inviaUtils.saveAirport(airport, bindingResult, model);
    }


    @GetMapping("/airport/delete")
    public String deleteAirport(@PathParam("airportId") long airportId, Model model){
        return inviaUtils.deleteAirport(airportId, model);
    }

    @GetMapping("/airports")
    public String showAirportsList(@RequestParam(defaultValue = "0") int pageNo, Model model) {
        return inviaUtils.showAirportsList(pageNo, model);
    }

    @GetMapping("/aircraft/new")
    public String showAddAircraftPage(Model model) {
        return inviaUtils.showAircraftPage(model);
    }

    @PostMapping("/aircraft/new")
    public String saveAircraft(@Valid @ModelAttribute("aircraft") Aircraft aircraft, BindingResult bindingResult, Model model) {
        return inviaUtils.saveAircraft(aircraft, bindingResult, model);
    }

    @GetMapping("/aircraft/delete")
    public String deleteAircraft(@PathParam("aircraftId") int aircraftId, Model model){
        aircraftService.deleteAircraftById(aircraftId);
        model.addAttribute(InviaConstants.aircrafts, aircraftService.getAllAircraftsPaged(0));
        model.addAttribute(InviaConstants.currentPage, 0);
        return InviaConstants.aircrafts;
    }

    @GetMapping("/aircrafts")
    public String showAircraftsList(@RequestParam(defaultValue = "0") int pageNo, Model model) {
        return inviaUtils.showAircracftList(pageNo, model);
    }

    @GetMapping("/flight/new")
    public String showNewFlightPage(Model model) {
        return inviaUtils.showNewFlightPage(model);
    }


    @PostMapping("/flight/new")
    public String saveFlight(@Valid @ModelAttribute(InviaConstants.flight) Flight flight, BindingResult bindingResult,
                             @RequestParam("departureAirport") int departureAirport,
                             @RequestParam("destinationAirport") int destinationAirport,
                             @RequestParam("aircraft") int aircraftId,
                             @RequestParam("arrivalTime") String arrivalTime,
                             @RequestParam("departureTime") String departureTime,
                             Model model) {

        return inviaUtils.saveFlight(flight, bindingResult, departureAirport, destinationAirport, aircraftId, arrivalTime, departureTime, model);
    }



    @GetMapping("/flight/delete")
    public String deleteFlight(@PathParam("flightId") int flightId, Model model){
        return inviaUtils.deleteFilght(flightId, model);
    }



    @GetMapping("/flights")
    public String showFlightsList(@RequestParam(defaultValue = "0") int pageNo, Model model) {
        return inviaUtils.showFlightsList(pageNo, model);
    }



    @GetMapping("/flight/search")
    public String showSearchFlightPage(Model model) {
        return inviaUtils.showSearchFlightPage(model);
    }



    @PostMapping("/flight/search")
    public String searchFlight(@RequestParam("departureAirport") int departureAirport,
                               @RequestParam("destinationAirport") int destinationAirport,
                               @RequestParam("departureTime") String departureTime,
                               Model model) {
        return inviaUtils.searchFlight(departureAirport, destinationAirport, departureTime, model);
    }

    @GetMapping("/flight/book")
    public String showBookFlightPage(Model model) {
        return inviaUtils.showBookFlightPage(model);
    }


    @PostMapping("/flight/book")
    public String searchFlightToBook(@RequestParam("departureAirport") int departureAirport,
                                     @RequestParam("destinationAirport") int destinationAirport,
                                     @RequestParam("departureTime") String departureTime,
                                     Model model) {
        return inviaUtils.searchFlightToBook(departureAirport, destinationAirport, departureTime, model);
    }

    @GetMapping("/flight/book/new")
    public String showCustomerInfoPage(@RequestParam int flightId, Model model) {
        return showCustomerInfoPages(flightId, model);
    }

    public String showCustomerInfoPages(@RequestParam int flightId, Model model) {
        model.addAttribute("flightId", flightId);
        model.addAttribute(passenger, new Passenger());
        return "newPassenger";
    }

    @PostMapping("/flight/book/new")
    public String bookFlight(@Valid @ModelAttribute("passenger") Passenger passenger, BindingResult bindingResult, @RequestParam("flightId") int flightId, Model model) {
        return inviaUtils.bookFlight(passenger, flightId, model);
    }



    @GetMapping("/flight/book/verify")
    public String showVerifyBookingPage() {
        return verifyBooking;
    }

    @PostMapping("/flight/book/verify")
    public String showVerifyBookingPageResult(@RequestParam("flightId") int flightId,
                                              @RequestParam("passengerId") String passengerId,
                                              Model model) {
        return inviaUtils.showVerifyBookingPageResult(flightId, passengerId, model);

    }

    @PostMapping("/flight/book/cancel")
    public String cancelTicket(@RequestParam("passengerId") String passengerId, Model model){
        return inviaUtils.cancelTicket(passengerId, model);
    }


    @GetMapping("passengers")
    public String showPassengerList(@RequestParam int flightId, Model model){
        return inviaUtils.showPassengerList(flightId, model);
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return login;
    }



    @GetMapping("fancy")
    public String showLoginPage1(){
        return index;
    }
}
