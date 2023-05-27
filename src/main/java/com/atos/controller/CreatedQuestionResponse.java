package com.atos.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CreatedQuestionResponse {

    private String id;

    private Date createdAt;

    private String createdBy;

    private String message;
}
