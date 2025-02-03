package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.QuizQuestion;

public interface QuizRepository extends JpaRepository<QuizQuestion, Integer> {

	Optional<QuizQuestion> findByCategory(String category);
	
	
}