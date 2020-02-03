package com.invia.flightticketbooking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/health")
    public String firstPage() {
        return "Hello Invia Flight booking application successfully deployed and started...";
    }


}
