package com.atos.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "question")
public class Question {

    @Id
    private String id;

    private String name;

    @Field("level_id")
    private String levelId;

    private String category;

    @Field("sub_category")
    private String subCategory;

    private Double mark;

    @Field("expected_time")
    private Double expectedTime;

    @Field("corrected-answers-id")
    private List<String> correctedAnswersId = new ArrayList<>();

    @Field("created-by")
    private String createdBy;

    @Field("created-at")
    private Date createdAt;

    private List<Answer> answers;

    public void updateAnswersId(){
        char answerId = 'A';
        for(Answer answer : this.getAnswers()){
            answer.setId(String.valueOf(answerId));
            answerId++;
        }
    }
}
