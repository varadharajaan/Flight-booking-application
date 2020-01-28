package com.invia.flightticketbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Varadharajan
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValueNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 6601130339967844171L;

    public ValueNotFoundException() {
        super();
    }

    public ValueNotFoundException(String message) {
        super(message);
    }

}
