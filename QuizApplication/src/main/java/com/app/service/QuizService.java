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
    
    // Add a new quiz question
    @Override
    public QuizQuestion addQuestion(QuizQuestion question) {
        return quizRepository.save(question);
    }
    
    @Override
    public List<QuizQuestion> addMultipleQuestions(List<QuizQuestion> questions) {
        return quizRepository.saveAll(questions);  // Save multiple questions
    }

    // Get all quiz questions
    @Override
    public List<QuizQuestion> getAllQuestions() {
        return quizRepository.findAll();
    }

    // Get a specific quiz question by ID
    @Override
    public QuizQuestion getQuestionById(int id) {
        return quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
    }
    
    // Get quiz questions by category
    @Override
    public List<QuizQuestion> getQuestionByCategory(String category) {
        List<QuizQuestion> questions = quizRepository.findByCategory(category);
        if (questions.isEmpty()) {
            throw new RuntimeException("No questions found for the category: " + category);
        }
        return questions;
    }

    // Update an existing quiz question
    @Override
    public QuizQuestion updateQuestion(int id, QuizQuestion updatedQuestion) {
    	
    	QuizQuestion existingQuestion = quizRepository.findById(id)
    	        .orElseThrow(() -> new RuntimeException("Question not found"));  // Throw an exception if not found
    		
    	if(existingQuestion!=null) {
    	    existingQuestion.setQuestionTitle(updatedQuestion.getQuestionTitle());
    	    existingQuestion.setCategory(updatedQuestion.getCategory());
    	    existingQuestion.setOption1(updatedQuestion.getOption1());
    	    existingQuestion.setOption2(updatedQuestion.getOption2());
    	    existingQuestion.setOption3(updatedQuestion.getOption3());
    	    existingQuestion.setOption4(updatedQuestion.getOption4());
    	    existingQuestion.setRightAnswer(updatedQuestion.getRightAnswer());
    	    existingQuestion.setDifficultyLevel(updatedQuestion.getDifficultyLevel());
    	    return quizRepository.save(existingQuestion);

    	}
    	else {
    		return null;
    	}
    	}
    // Delete a quiz question by ID
    @Override
    public void deleteQuestion(int id) {
        quizRepository.deleteById(id);
    }
}
