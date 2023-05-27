package com.atos.DTO;

import com.atos.entity.Question;

public class QuestionMapper {
    public Question questionDtoToQuestion(QuestionDto questionDto) {
        Question question = new Question();
        question.setName(questionDto.getName());
        question.setLevelId(questionDto.getLevelId());
        question.setCategory(questionDto.getCategory());
        question.setSubCategory(questionDto.getSubCategory());
        question.setMark(questionDto.getMark());
        question.setExpectedTime(questionDto.getExpectedTime());
        question.setCorrectedAnswersId(questionDto.getCorrectedAnswersId());
        question.setAnswers(questionDto.getAnswers());
        return question;
    }

    public Question updateQuestion(Question question, QuestionDto questionDto){
        if(questionDto.getName() != null) question.setName(questionDto.getName());
        if(questionDto.getLevelId() != null) question.setLevelId(questionDto.getLevelId());
        if(questionDto.getCategory() != null) question.setCategory(questionDto.getCategory());
        if(questionDto.getSubCategory() != null) question.setSubCategory(questionDto.getSubCategory());
        if(questionDto.getMark() != null) question.setMark(questionDto.getMark());
        if(questionDto.getExpectedTime() != null) question.setExpectedTime(questionDto.getExpectedTime());
        if(questionDto.getCorrectedAnswersId() != null) question.setCorrectedAnswersId(questionDto.getCorrectedAnswersId());
        if(questionDto.getAnswers() != null) question.setAnswers(questionDto.getAnswers());
        return question;
    }

}
