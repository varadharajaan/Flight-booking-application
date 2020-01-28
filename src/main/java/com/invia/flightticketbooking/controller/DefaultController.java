package com.invia.flightticketbooking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DefaultController {

    @RequestMapping("/")
    public String firstPage() {
        return "Hello Invia Flight booking application successfully deployed and started...";
    }


}
