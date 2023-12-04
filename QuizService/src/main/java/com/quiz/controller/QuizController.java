package com.quiz.controller;

import com.quiz.entity.Quiz;
import com.quiz.entity.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping
    public Quiz create(@RequestBody Quiz quiz){
        return quizService.add(quiz);
    }

    @GetMapping
    public List<Quiz> findAll()
    {
        return quizService.getAll();
    }

    @GetMapping("/{id}")
    public Quiz getOne(@PathVariable long id)
    {
        return quizService.getSingle(id);
    }

}
