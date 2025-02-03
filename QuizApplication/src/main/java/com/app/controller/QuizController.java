package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.model.QuizQuestion;
import com.app.serviceint.QuizServiceint;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizServiceint quizService;
    
    @PostMapping("/addQuestions")
    public QuizQuestion addQuestion(@RequestBody QuizQuestion question) {
        return quizService.addQuestion(question);
    }

    @GetMapping("/allQuestions")
    public List<QuizQuestion> getAllQuestions() {
        return quizService.getAllQuestions();
    }

    @GetMapping("/idQuestions/{id}")
    public QuizQuestion getQuestionById(@PathVariable int id) {
        return quizService.getQuestionById(id);
    }

    @GetMapping("/categoryQuestions/{id}")
    public QuizQuestion getQuestionByCategory(@PathVariable String category) {
        return quizService.getQuestionByCategory(category);
    }

    @PutMapping("/updateQuestions/{id}")
    public QuizQuestion updateQuestion(@PathVariable int id, @RequestBody QuizQuestion question) {
        return quizService.updateQuestion(id, question);
    }

    @DeleteMapping("/deleteQuestions/{id}")
    public void deleteQuestion(@PathVariable int id) {
        quizService.deleteQuestion(id);
    }
}
