package com.atos.DTO;

import com.atos.entity.Answer;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionDto {

    @NotBlank
    private String name;


    @NotBlank
    @Pattern(regexp = "^(easy|medium|hard)$")
    private String levelId;

    @Size(max = 30)
    @NotBlank
    private String category;

    @Size(max = 30)
    private String subCategory;

    @NotNull
    @Min(0)
    @Max(25)
    private Double mark;


    @Min(1)
    @Max(30)
    private Double expectedTime;

    private List<String> correctedAnswersId = new ArrayList<>();

    @NotEmpty
    @Size(max = 11)
    private List<Answer> answers;
}
