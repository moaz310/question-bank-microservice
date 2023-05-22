package com.atos.service;

import com.atos.entity.Answer;
import com.atos.entity.Question;
import com.atos.entity.QuestionList;
import com.atos.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public Question createQuestion(Question question){
        question.setCreatedAt(new java.util.Date());
        return questionRepository.save(question);
    }

    public void deleteQuestionById(String Id){
        questionRepository.deleteById(Id);
    }

    public QuestionList getWithPagination(Pageable pageable){
        return new QuestionList(questionRepository.findAll(pageable).getContent());
    }

    public Question updateQuestion(Question question, String questionId){
        if(questionRepository.findById(questionId).isPresent()) {
            return questionRepository.save(question);
        }
        return null;
    }

    public Answer addAnswer(String questionId, Answer answer){
        Optional<Question> questionObject = questionRepository.findById(questionId);

        if(questionObject.isEmpty()) return null;

        Question question = questionObject.get();
        question.getAnswers().add(answer);
        updateQuestion(question, answer.getId());

        return answer;
    }


    public void deleteAnswer(String questionId, String answerId) {
        Optional<Question> questionObject = questionRepository.findById(questionId);

        if(questionObject.isEmpty()) return;

        Question question = questionObject.get();
        for(Answer answer : question.getAnswers()){
            if(answer.getId().equals(answerId)){
                question.getAnswers().remove(answer);
                System.out.println("yes");
                updateQuestion(question, questionId);
                return;
            }
        }
    }

    public long getDataCount(){
        return questionRepository.count();
    }
}
