package com.saveTravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saveTravels.models.Expense;

@Repository
public interface ExpenseRespsitory extends CrudRepository<Expense, Long>{
    // this method retrieves all the Expenses from the database
    //We need only this, for now:	
	List<Expense> findAll();
	
	// Optional and advanced methods :
	// this method finds books with descriptions containing the search string
    List<Expense> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByNameContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByNameStartingWith(String search);
}
