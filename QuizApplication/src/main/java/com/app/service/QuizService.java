package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.QuizQuestion;
import com.app.repository.QuizRepository;
import com.app.serviceint.QuizServiceint;

import java.util.List;

@Service
public class QuizService implements QuizServiceint {

    @Autowired
    private QuizRepository quizRepository;

    // Get all quiz questions
    public List<QuizQuestion> getAllQuestions() {
        return quizRepository.findAll();
    }

    // Get a specific quiz question by ID
    public QuizQuestion getQuestionById(int id) {
        return quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
    }
    
	@Override
	public QuizQuestion getQuestionByCategory(String category) {
		return quizRepository.findByCategory(category).orElseThrow(() -> new RuntimeException("Question not found"));
		
	}
	
    // Add a new quiz question
    public QuizQuestion addQuestion(QuizQuestion question) {
        return quizRepository.save(question);
    }

    // Update an existing quiz question
    public QuizQuestion updateQuestion(int id, QuizQuestion updatedQuestion) {
        QuizQuestion question = getQuestionById(id);
        question.setQuestionTitle(updatedQuestion.getQuestionTitle());  // Assuming the field is questionTitle
        question.setOption1(updatedQuestion.getOption1());              // Assuming field is option1
        question.setOption2(updatedQuestion.getOption2());              // Assuming field is option2
        question.setOption3(updatedQuestion.getOption3());              // Assuming field is option3
        question.setOption4(updatedQuestion.getOption4());              // Assuming field is option4
        question.setRightAnswer(updatedQuestion.getRightAnswer());      // Assuming field is rightAnswer
        question.setDifficultyLevel(updatedQuestion.getDifficultyLevel()); // Assuming field is difficultyLevel
        return quizRepository.save(question);
    }

    public void deleteQuestion(int id) {
        quizRepository.deleteById(id);
    }

}
