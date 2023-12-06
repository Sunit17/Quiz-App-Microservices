package com.quiz.service;

import com.quiz.Repository.QuizRepo;
import com.quiz.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;


    public Quiz add(Quiz quiz)
    {
        return quizRepo.save(quiz);
    }

    public List<Quiz> getAll()
    {
        return quizRepo.findAll();
    }

    public Quiz getSingle(long id)
    {
        return quizRepo.findById(id).orElseThrow(()-> new RuntimeException("Quiz Not found"));
    }



}
