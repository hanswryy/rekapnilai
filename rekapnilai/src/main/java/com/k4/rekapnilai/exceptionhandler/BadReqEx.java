package com.k4.rekapnilai.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Type mismatch")
public class BadReqEx extends RuntimeException{
    public BadReqEx(String message) {
        super(message);
    }
}
