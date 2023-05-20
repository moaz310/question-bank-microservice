package com.atos.controller;

import com.atos.entity.Answer;
import com.atos.entity.Question;
import com.atos.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("/create")
    public Question createQuestion(@RequestBody Question q){
        return questionService.createQuestion(q);
    }

    @PostMapping("/createQuestions")
    public List<Question> createQuestion(@RequestBody List<Question> q){
        return questionService.createQuestions(q);
    }

    @PutMapping("/deleteById")
    public void deleteById(@RequestParam String id){
        questionService.deleteQuestionById(id);
    }

    @PutMapping("/delete")
    public void delete(@RequestBody Question q){
        questionService.deleteQuestion(q);
    }

    @GetMapping("/getWithPagination")
    public List<Question> getWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        return questionService.getWithPagination(pageNo, pageSize);
    }

    @PutMapping("/update")
    public Question updateQuestion(@RequestBody Question q){
        return questionService.updateQuestion(q);
    }

    @PutMapping("/addAnswerTo/{id}")
    public Question addAnswerToSpecificQuestion(@PathVariable String id, @RequestBody Answer answer){
        return questionService.addAnswer(id, answer);
    }

    @PutMapping("/deleteAnswerFrom/{id}")
    public Question deleteAnswerFromSpecificQuestion(@PathVariable String id, @RequestBody Answer answer){
        return questionService.deleteAnswer(id, answer);
    }
}
