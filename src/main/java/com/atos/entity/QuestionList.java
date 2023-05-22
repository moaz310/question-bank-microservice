package com.atos.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class QuestionList {
    List<Question> questions;
    public QuestionList(List<Question> questions) {
        this.questions = questions;
    }
}
