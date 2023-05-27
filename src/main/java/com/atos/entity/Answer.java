package com.atos.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    private String id;

    @NotBlank
    private String name;

    private String description;

}
