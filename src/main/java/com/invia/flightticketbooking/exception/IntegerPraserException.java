package com.invia.flightticketbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IntegerPraserException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 6601130339967844171L;

    public IntegerPraserException() {
        super();
    }

    public IntegerPraserException(String message) {
        super(message);
    }

}
