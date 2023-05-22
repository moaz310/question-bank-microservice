package com.atos.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter @Setter
public class Answer {
    @Id
    private String id;

    private String name;

    private String description;

    public Answer() {
    }

    public Answer(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
