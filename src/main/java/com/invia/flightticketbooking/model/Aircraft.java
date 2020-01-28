package com.invia.flightticketbooking.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aircraft")
public class Aircraft extends AuditEntity {
    @Id
    @GeneratedValue
    private int aircraftId;
    @Column(name = "manufacturer", length = 20)
    private String manufacturer;
    @Column(name = "model", length = 20 , nullable = false)
    private String model;
    @Column(name = "numberOfSeats", length = 20, nullable = false)
    private Integer numberOfSeats;

    @OneToMany(mappedBy = "aircraft")
    private List<Flight> flights = new ArrayList<>();


    public Aircraft() {
    }

    public Aircraft( String manufacturer, String model, Integer numberOfSeats) {

        this.manufacturer = manufacturer;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
    }

    public int getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(int aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }



    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
