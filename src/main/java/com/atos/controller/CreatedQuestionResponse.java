package com.atos.controller;

import com.atos.entity.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class CreatedQuestionResponse {

    private String id;

    private Date createdAt;

    private String createdBy;

    private List<Answer> answers;

    private String message;

}
