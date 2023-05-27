package com.atos.exception;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class APIError {

    private String errorMessage;

    private String errorCode;

    private String request;

    private String requestType;

    private String customMessage;

}