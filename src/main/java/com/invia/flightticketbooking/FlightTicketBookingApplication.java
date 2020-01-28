package com.invia.flightticketbooking;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;


@SpringBootApplication
@EnableHystrixDashboard
@EnableSwagger2
public class FlightTicketBookingApplication extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    DataInitializerImpl dataInitializer;
    public static void main(String[] args) {
        SpringApplication.run(FlightTicketBookingApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FlightTicketBookingApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {

        dataInitializer.initData();
    }

}