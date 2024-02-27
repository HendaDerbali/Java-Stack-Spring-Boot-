package com.dojoOverflowAssignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojoOverflowAssignment.models.Answer;


@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

	// this method retrieves all the books from the database
	// Mondatory
	List<Answer> findAll();

}