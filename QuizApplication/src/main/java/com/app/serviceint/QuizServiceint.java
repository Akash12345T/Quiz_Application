package com.app.serviceint;

import java.util.List;

import com.app.model.QuizQuestion;

public interface QuizServiceint {

	public List<QuizQuestion> getAllQuestions();

	public QuizQuestion getQuestionById(int id);

	public QuizQuestion addQuestion(QuizQuestion question);

	public QuizQuestion updateQuestion(int id, QuizQuestion question);

	public void deleteQuestion(int id);

	public List<QuizQuestion> getQuestionByCategory(String category);

	List<QuizQuestion> addMultipleQuestions(List<QuizQuestion> questions);


}
