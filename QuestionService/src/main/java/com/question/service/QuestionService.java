package com.question.service;

import com.question.entity.Question;
import com.question.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    
    @Autowired
    private QuestionRepo questionRepo;
    
    public Question createQuestions(Question question)
    {
        return questionRepo.save(question);
    }
    
    public List<Question> getAllQuestion()
    {
        return questionRepo.findAll();
    }
    
    public Question getSingle(Long questionId)
    {
        return questionRepo.findById(questionId).orElseThrow(()-> new RuntimeException(" Id is not found"));
    }

    public List<Question> getByQuizId(Long quizId)
    {
        return questionRepo.findByQuizId(quizId);
    }
    
}
