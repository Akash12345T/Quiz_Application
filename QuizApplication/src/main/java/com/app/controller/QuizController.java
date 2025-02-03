package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.QuizQuestion;
import com.app.serviceint.QuizServiceint;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
	
	@Autowired
    private QuizServiceint quizService;

	// Add a single quiz question
    @PostMapping("/addQuestions")
    public ResponseEntity<QuizQuestion> addQuestion(@RequestBody QuizQuestion question) {
        QuizQuestion savedQuestion = quizService.addQuestion(question);
        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);  // Return status 201 for created
    }
	
	// Add multiple quiz questions
	@PostMapping("/addMultipleQuestions")
	public ResponseEntity<List<QuizQuestion>> addMultipleQuestions(@RequestBody List<QuizQuestion> questions) {
		List<QuizQuestion> savedMultipleQuestions = quizService.addMultipleQuestions(questions);
		return new ResponseEntity<>(savedMultipleQuestions, HttpStatus.CREATED);  // Return a list of saved questions with 201 status
	}

    // Get all questions
    @GetMapping("/allQuestions")
    public ResponseEntity<List<QuizQuestion>> getAllQuestions() {
        List<QuizQuestion> allQuestions = quizService.getAllQuestions();
        return new ResponseEntity<>(allQuestions, HttpStatus.OK);  // Return status 200 for success
    }

    // Get a specific question by ID
    @GetMapping("/idQuestions/{id}")
    public ResponseEntity<QuizQuestion> getQuestionById(@PathVariable int id) {
        QuizQuestion question = quizService.getQuestionById(id);
        return new ResponseEntity<>(question, HttpStatus.OK);  // Return status 200 for success
    }

    // Get questions by category
    @GetMapping("/categoryQuestions/{category}")
    public ResponseEntity<List<QuizQuestion>> getQuestionsByCategory(@PathVariable String category) {
        List<QuizQuestion> questions = quizService.getQuestionByCategory(category);
        return new ResponseEntity<>(questions, HttpStatus.OK);  // Return status 200 for success
    }

    // Update a question by ID
    @PutMapping("/updateQuestions/{id}")
    public ResponseEntity<QuizQuestion> updateQuestion(@PathVariable int id, @RequestBody QuizQuestion question) {
        QuizQuestion updatedQuestion = quizService.updateQuestion(id, question);
        return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);  // Return status 200 for success
    }

    // Delete a question by ID
    @DeleteMapping("/deleteQuestions/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable int id) {
        quizService.deleteQuestion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Return status 204 for no content (successful deletion)
    }
}
