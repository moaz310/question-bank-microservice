package com.atos.controller;

import com.atos.entity.Answer;
import com.atos.entity.Question;
import com.atos.entity.QuestionList;
import com.atos.service.QuestionService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("${question.api.path}")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("${question.api.path.create}")
    public Question createQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }

    @DeleteMapping("${question.api.path.deleteById}")
    public void deleteById(@PathVariable String questionId){
        questionService.deleteQuestionById(questionId);
    }

    @GetMapping("${question.api.path.getWithPagination}")
    public QuestionList getWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return questionService.getWithPagination(pageable);
    }

    //add dto for this
    @PutMapping("${question.api.path.update}")
    public Question updateQuestion(@RequestBody Question question, @PathVariable String questionId){
        return questionService.updateQuestion(question, questionId);
    }

    @PatchMapping("${question.api.path.addAnswerTo}")
    public Answer addAnswerToSpecificQuestion(@PathVariable String questionId, @RequestBody Answer answer){
        return questionService.addAnswer(questionId, answer);
    }

    @DeleteMapping("${question.api.path.deleteAnswerFrom}")
    public void deleteAnswerFromSpecificQuestion(@PathVariable String questionId, @PathVariable String answerId){
        questionService.deleteAnswer(questionId, answerId);
    }

    @GetMapping("${question.api.path.count}")
    public long dataCount(){
        return questionService.getDataCount();
    }
}
