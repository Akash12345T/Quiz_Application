package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.QuizQuestion;

public interface QuizRepository extends JpaRepository<QuizQuestion, Integer> {

    // Use this method to find QuizQuestions by category
    List<QuizQuestion> findByCategory(String category);  // Return List of QuizQuestions by category
}