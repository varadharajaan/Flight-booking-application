package com.invia.flightticketbooking;

import com.invia.flightticketbooking.controller.MainController;
import com.invia.flightticketbooking.model.Aircraft;
import com.invia.flightticketbooking.model.Airport;
import com.invia.flightticketbooking.model.Flight;
import com.invia.flightticketbooking.model.Passenger;
import com.invia.flightticketbooking.repository.FlightRepository;
import com.invia.flightticketbooking.services.FlightService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.beans.PropertyEditor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @Author Varadharajan on 29/01/20 11:37
 * @Projectname invia-flightbooking-backend
 */
@RunWith(MockitoJUnitRunner.class)
public class FlightBookingServicesTest {


    @Mock
    MainController controller;

    @Mock
    FlightService flightService;

    @Mock
    FlightRepository flightRepository;

    BindingResult br = new BindingResult() {
        @Override
        public Object getTarget() {
            return null;
        }

        @Override
        public Map<String, Object> getModel() {
            return null;
        }

        @Override
        public Object getRawFieldValue(String field) {
            return null;
        }

        @Override
        public PropertyEditor findEditor(String field, Class<?> valueType) {
            return null;
        }

        @Override
        public PropertyEditorRegistry getPropertyEditorRegistry() {
            return null;
        }

        @Override
        public String[] resolveMessageCodes(String errorCode) {
            return new String[0];
        }

        @Override
        public String[] resolveMessageCodes(String errorCode, String field) {
            return new String[0];
        }

        @Override
        public void addError(ObjectError error) {

        }

        @Override
        public String getObjectName() {
            return null;
        }

        @Override
        public void setNestedPath(String nestedPath) {

        }

        @Override
        public String getNestedPath() {
            return null;
        }

        @Override
        public void pushNestedPath(String subPath) {

        }

        @Override
        public void popNestedPath() throws IllegalStateException {

        }

        @Override
        public void reject(String errorCode) {

        }

        @Override
        public void reject(String errorCode, String defaultMessage) {

        }

        @Override
        public void reject(String errorCode, Object[] errorArgs, String defaultMessage) {

        }

        @Override
        public void rejectValue(String field, String errorCode) {

        }

        @Override
        public void rejectValue(String field, String errorCode, String defaultMessage) {

        }

        @Override
        public void rejectValue(String field, String errorCode, Object[] errorArgs, String defaultMessage) {

        }

        @Override
        public void addAllErrors(Errors errors) {

        }

        @Override
        public boolean hasErrors() {
            return false;
        }

        @Override
        public int getErrorCount() {
            return 0;
        }

        @Override
        public List<ObjectError> getAllErrors() {
            return null;
        }

        @Override
        public boolean hasGlobalErrors() {
            return false;
        }

        @Override
        public int getGlobalErrorCount() {
            return 0;
        }

        @Override
        public List<ObjectError> getGlobalErrors() {
            return null;
        }

        @Override
        public ObjectError getGlobalError() {
            return null;
        }

        @Override
        public boolean hasFieldErrors() {
            return false;
        }

        @Override
        public int getFieldErrorCount() {
            return 0;
        }

        @Override
        public List<FieldError> getFieldErrors() {
            return null;
        }

        @Override
        public FieldError getFieldError() {
            return null;
        }

        @Override
        public boolean hasFieldErrors(String field) {
            return false;
        }

        @Override
        public int getFieldErrorCount(String field) {
            return 0;
        }

        @Override
        public List<FieldError> getFieldErrors(String field) {
            return null;
        }

        @Override
        public FieldError getFieldError(String field) {
            return null;
        }

        @Override
        public Object getFieldValue(String field) {
            return null;
        }

        @Override
        public Class<?> getFieldType(String field) {
            return null;
        }
    };

    Model model = new Model() {
        @Override
        public Model addAttribute(String attributeName, Object attributeValue) {
            return null;
        }

        @Override
        public Model addAttribute(Object attributeValue) {
            return null;
        }

        @Override
        public Model addAllAttributes(Collection<?> attributeValues) {
            return null;
        }

        @Override
        public Model addAllAttributes(Map<String, ?> attributes) {
            return null;
        }

        @Override
        public Model mergeAttributes(Map<String, ?> attributes) {
            return null;
        }

        @Override
        public boolean containsAttribute(String attributeName) {
            return false;
        }

        @Override
        public Map<String, Object> asMap() {
            return null;
        }
    };

    List<Aircraft> aircraftList = new ArrayList<>();
    List<Flight> depflightList = new ArrayList<>();

    List<Flight> desflightList = new ArrayList<>();
    Aircraft aircraft1 = new Aircraft();
    Aircraft aircraft2 = new Aircraft();
    Airport depAirport = new Airport();
    Airport desAirport = new Airport();
    Flight flight1 = new Flight();
    Flight flight2 = new Flight();
    List<Passenger> passengerList = new ArrayList<>();
    Passenger passenger = new Passenger();
    @Before
    public void setUp()
    {
        initMocks(this);


        aircraft1.setAircraftId(21);
        aircraft1.setManufacturer("boeing");
        aircraft1.setModel("rrwwr");
        aircraft1.setNumberOfSeats(45);
        aircraft1.setFlights(depflightList);


        aircraft1.setAircraftId(22);
        aircraft1.setManufacturer("airbus");
        aircraft1.setModel("bmw");
        aircraft1.setNumberOfSeats(55);
        aircraft1.setFlights(desflightList);



        depAirport.setAirportCode("NEW-001");
        depAirport.setAirportId(1);
        depAirport.setAirportName("Germany");
        depAirport.setCity("Munich");
        depAirport.setFlights(depflightList);


        desAirport.setAirportCode("NEW-002");
        desAirport.setAirportId(1);
        desAirport.setAirportName("United States");
        desAirport.setCity("New Yourk");
        desAirport.setFlights(desflightList);




        passenger.setFlight(flight1);
        passenger.setAddress("usa");
        passenger.setEmail("varathu09@gmail.com");
        passenger.setFirstName("varadha");
        passenger.setLastName("rajan");
        passenger.setPassengerId("123");
        passenger.setPassportNumber("8754152743");
        passengerList.add(passenger);

        flight1.setArrivalTime("2.00 PM");
        flight1.setAircraft(aircraft1);
        flight1.setDepartureAirport(depAirport);
        flight1.setDestinationAirport(desAirport);
        flight1.setPassengers(passengerList);
        flight1.setFlightId(1);

        flight2.setArrivalTime("4.00 PM");
        flight2.setAircraft(aircraft2);
        flight2.setDepartureAirport(depAirport);
        flight2.setDestinationAirport(desAirport);
        flight2.setPassengers(passengerList);
        flight2.setFlightId(2);

        depflightList.add(flight1);
        desflightList.add(flight2);
    }

    @After
    public void destroy () {

        aircraftList.clear();
        depflightList.clear();

         desflightList.clear();
         aircraft1 = new Aircraft();
         aircraft2 = new Aircraft();
         depAirport = new Airport();
         desAirport = new Airport();
         flight1 = new Flight();
         flight2 = new Flight();
         passengerList.clear();
         passenger = new Passenger();
    }

    @Test
    public void  CheckFlightBooking(){

        when(flightService.getAllFlights()).thenReturn(depflightList);

        final List<Flight> allFlights = flightService.getAllFlights();

        assertEquals(allFlights,depflightList);

       when(flightService.saveFlight(flight1)).thenReturn(flight1);

        final Flight flight = flightService.saveFlight(flight1);

        assertEquals(flight,flight1);

        when(flightService.getFlightById(anyInt())).thenReturn(flight1);

        final Flight flightById = flightService.getFlightById(1);

        final Flight flightById1 = flightService.getFlightById(3);

        assertEquals(flightById,flightById1);


    }

    @Test
    public void DiffrentAirportCheck(){

        when(flightService.getAllFlightsByAirportAndDepartureTime(any(Airport.class),any(Airport.class),any(LocalDate.class))).thenReturn(depflightList);

        final List<Flight> allFlightsByAirportAndDepartureTime = flightService.getAllFlightsByAirportAndDepartureTime(depAirport, desAirport, LocalDate.now());

        allFlightsByAirportAndDepartureTime.forEach( a->
                assertEquals(a.getFlightId(),1));

    }

    @Test
    public void bookingFlightsDifferentScenario(){

        when(flightService.getAllFlightsByAirportAndDepartureTime(any(Airport.class),any(Airport.class),any(LocalDate.class))).thenReturn(depflightList);

        List<Flight> allFlightsByAirportAndDepartureTime = flightService.getAllFlightsByAirportAndDepartureTime(depAirport, desAirport, LocalDate.now());


        allFlightsByAirportAndDepartureTime.forEach( a->
                assertEquals(a.getFlightId(),1));


    }

    @Test
    public  void bookingforDiffrentCraft() {
        when(flightRepository.findAllByDepartureAirportEqualsAndDestinationAirportEqualsAndDepartureDateEquals(any(Airport.class),any(Airport.class),any(LocalDate.class))).thenReturn(depflightList);

        List<Flight> allFlightsByAirportAndDepartureTime = flightService.getAllFlightsByAirportAndDepartureTime(depAirport, desAirport, LocalDate.now());

        allFlightsByAirportAndDepartureTime.forEach( a->
                assertEquals(a.getFlightId(),1));
    }


    @Test
    public void flightControllerTest() {
        controller.bookFlight(passenger, br, 23,model);

    }


}
