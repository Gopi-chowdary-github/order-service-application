package com.microservice.orderservice.exceptionHandler;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExceptionResponse {

    private String type;
    private String message;

    private String logRefId;

    public ExceptionResponse(String type, String message, String logRefId) {
        this.type = type;
        this.message = message;
        this.logRefId = logRefId;
    }
}
