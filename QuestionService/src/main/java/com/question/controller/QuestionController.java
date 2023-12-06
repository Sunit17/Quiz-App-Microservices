package com.question.controller;

import com.question.entity.Question;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public Question addQuestion(@RequestBody Question question)
    {
        return questionService.createQuestions(question);
    }

    @GetMapping
    public List<Question> getAllQuestions()
    {
        return questionService.getAllQuestion();
    }

    @GetMapping("/{questionId}")
    public Question getSingleQuestion(@PathVariable Long questionId)
    {
        return questionService.getSingle(questionId);
    }


}
