package com.atos.service;

import com.atos.DTO.QuestionDto;
import com.atos.DTO.QuestionMapper;
import com.atos.entity.*;
import com.atos.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    QuestionMapper mapper = new QuestionMapper();
    public Question createQuestion(QuestionDto questionDto){
        Question question = mapper.questionDtoToQuestion(questionDto);
        question.setCreatedAt(new java.util.Date());
        question.setCreatedBy("teacher");
        question.updateAnswersId();
        return questionRepository.save(question);
    }

    public void deleteQuestionById(String questionId){
        Optional<Question> questionObject = questionRepository.findById(questionId);
        if(questionObject.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No question found with id " + questionId);
        questionRepository.deleteById(questionId);
    }

    public QuestionList getWithPagination(Pageable pageable){
        return new QuestionList(questionRepository.findAll(pageable).getContent());
    }

    public Question updateQuestion(QuestionDto questionDto, String questionId){
        Optional<Question> questionObject = questionRepository.findById(questionId);
        if(questionObject.isPresent()) {
            Question questionUpdate = mapper.updateQuestion(questionObject.get(), questionDto);
            questionUpdate.updateAnswersId();
            return questionRepository.save(questionUpdate);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No question found with id " + questionId);
    }

    public Answer addAnswer(String questionId, Answer answer){
        Optional<Question> questionObject = questionRepository.findById(questionId);

        if(questionObject.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No question found with id " + questionId);

        Question question = questionObject.get();
        question.getAnswers().add(answer);
        question.updateAnswersId();
        this.questionRepository.save(question);
        return answer;
    }


    public void deleteAnswer(String questionId, String answerId) {
        Optional<Question> questionObject = questionRepository.findById(questionId);
        if(questionObject.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No question found with id " + questionId);

        Question question = questionObject.get();
        for (Answer answer : question.getAnswers()) {
            if (answer.getId().equals(answerId)) {
                question.getAnswers().remove(answer);
                question.updateAnswersId();
                this.questionRepository.save(question);
                return;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Answer found with id: " + answerId + " on question with id: " + questionId);
    }

    public long getDataCount(){
        return questionRepository.count();
    }
}
