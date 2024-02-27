package com.dojoOverflowAssignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojoOverflowAssignment.models.Question;


@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
	
	
	// this method retrieves all the questions from the database
	// Mondatory
	List<Question> findAll();

}