package com.atos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
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
    private List<String> correctedAnswersId;

    @Field("created-by")
    private String createdBy;

    @Field("created-at")
    private Date createdAt;

    private List<Answer> answers;
}
