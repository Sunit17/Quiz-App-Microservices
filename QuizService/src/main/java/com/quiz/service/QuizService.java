package com.quiz.service;

import com.quiz.Repository.QuizRepo;
import com.quiz.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private QuestionClient questionClient;


    public Quiz add(Quiz quiz)
    {
        return quizRepo.save(quiz);
    }

    public List<Quiz> getAll()
    {
        List<Quiz> quizzes= quizRepo.findAll();

        List<Quiz> newQuizlist= quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizlist;
    }

    public Quiz getSingle(long id)
    {
        return quizRepo.findById(id).orElseThrow(()-> new RuntimeException("Quiz Not found"));
    }



}
