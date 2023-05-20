package com.atos.service;

import com.atos.entity.Answer;
import com.atos.entity.Question;
import com.atos.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public Question createQuestion(Question q){
        System.out.println(new java.util.Date());
        q.setCreatedAt(new java.util.Date());
        return questionRepository.save(q);
    }

    public List<Question> createQuestions(List<Question> q){
        q.forEach(question -> {question.setCreatedAt(new java.util.Date());});
        return questionRepository.saveAll(q);
    }

    public void deleteQuestionById(String Id){
        questionRepository.deleteById(Id);
    }

    public void deleteQuestion(Question q){
        questionRepository.delete(q);
    }

    public List<Question> getWithPagination(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return questionRepository.findAll(pageable).getContent();
    }

    public Question updateQuestion(Question q){
        return questionRepository.save(q);
    }

    public Question addAnswer(String questionId, Answer ans){
        Question q = questionRepository.findById(questionId).get();
        q.getAnswers().add(ans);
        updateQuestion(q);
        return q;
    }

    public Question deleteAnswer(String questionId, Answer answer) {
        Question q = questionRepository.findById(questionId).get();
        System.out.println(q.getAnswers().remove(answer));
        updateQuestion(q);
        return q;
    }
}
