package com.saveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.saveTravels.models.Expense;
import com.saveTravels.repositories.ExpenseRespsitory;



@Service
public class ExpenseService {
	// adding the Expense repository as a dependency
    private final ExpenseRespsitory expenseRepository;
    
    public ExpenseService(ExpenseRespsitory expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    
    // returns all Expenses
    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
    
    // creates an Expensive
    public Expense createExpense(Expense b) {
        return expenseRepository.save(b);
    }
    
    // retrieves an Expense 
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {  //isPresent() : method to check if our object exists.
            return optionalExpense.get();
        } else {
            return null;
        }
    }
     // update an Expensive
  	  public Expense updateExpense(Expense b) {
        return expenseRepository.save(b);
    }
  	  
     // find by containing ( findByDescriptionContaining : should be implemented in the repository)
  	  public List<Expense> expensesContaining(String search) {
        return expenseRepository.findByDescriptionContaining(search);
    }
  	  
  	 // Delete an Expensive
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}

}
