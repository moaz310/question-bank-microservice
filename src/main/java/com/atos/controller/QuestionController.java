package com.atos.controller;

import com.atos.DTO.QuestionDto;
import com.atos.DTO.QuestionMapper;
import com.atos.entity.Answer;
import com.atos.entity.Question;
import com.atos.entity.QuestionList;
import com.atos.service.QuestionService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@CrossOrigin
@Validated
@RequestMapping("${question.api.path}")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @PostMapping("${question.api.path.create}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CreatedQuestionResponse createQuestion(@Valid @RequestBody QuestionDto questiondto){
        Question question = this.questionService.createQuestion(questiondto);
        return new CreatedQuestionResponse(
                question.getId(),
                question.getCreatedAt(),
                question.getCreatedBy(),
                question.getAnswers(),
                "question created"
        );
    }

    @DeleteMapping("${question.api.path.deleteById}")
    @ResponseStatus(code = HttpStatus.OK, reason = "question deleted")
    public void deleteById(@PathVariable String questionId){
        questionService.deleteQuestionById(questionId);
    }

    @GetMapping("${question.api.path.getWithPagination}")
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    public QuestionList getWithPagination(Pageable pageable){
        return questionService.getWithPagination(pageable);
    }

    //add dto for this
    @PutMapping("${question.api.path.update}")
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    public CreatedQuestionResponse updateQuestion(@RequestBody QuestionDto questionDto, @PathVariable String questionId){
        Question question = questionService.updateQuestion(questionDto, questionId);
        return new CreatedQuestionResponse(
                question.getId(),
                question.getCreatedAt(),
                question.getCreatedBy(),
                question.getAnswers(),
                "question updated"
        );
    }

    @PatchMapping("${question.api.path.addAnswerTo}")
    @ResponseStatus(code = HttpStatus.CREATED)
    @ResponseBody
    public Answer addAnswerToSpecificQuestion(@PathVariable String questionId, @Valid @RequestBody Answer answer){
        return questionService.addAnswer(questionId, answer);
    }

    @DeleteMapping("${question.api.path.deleteAnswerFrom}")
    @ResponseStatus(code = HttpStatus.OK, reason = "delete-answer")
    public void deleteAnswerFromSpecificQuestion(@PathVariable String questionId, @PathVariable String answerId){
        questionService.deleteAnswer(questionId, answerId);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    @GetMapping("${question.api.path.count}")
    public long dataCount(){
        return questionService.getDataCount();
    }

}
