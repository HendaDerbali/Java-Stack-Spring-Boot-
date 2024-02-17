package com.saveTravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saveTravels.models.Expense;
import com.saveTravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;

	// ? Create + Get All ( in the same jsp page):

	@GetMapping("")
	public String home(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}

	// Form in the same page as Get All
	@PostMapping("/addExpense")
	public String home(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		}
		expenseService.createExpense(expense);
		return "redirect:/";
	}

	// ? Edit :
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}

	@RequestMapping(value = "/editExpense/{id}", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expense", expense);
			return "edit.jsp";
		} else {
			expenseService.updateExpense(expense);
			return "redirect:/";
		}
	}

	// ? Delete :
	@RequestMapping(value = "/deleteExpense/{id}", method = RequestMethod.DELETE)
	// we can use also : @DeleteMapping("/deleteBurger/{id}")
	public String destroy(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/";
	}
	

	// ? Get One By id
	@RequestMapping("/expenses/{id}")
	// Model bech yhez data:
	public String showOne(Model model, @PathVariable("id") Long id) {
		// Fetch the book by its ID and add it to the model
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		System.out.println(expense); // just to show my console

		return "showOne.jsp";
	}


}
