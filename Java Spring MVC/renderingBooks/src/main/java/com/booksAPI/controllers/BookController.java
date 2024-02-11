package com.booksAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booksAPI.models.Book;
import com.booksAPI.services.BookService;

@Controller
@RequestMapping("/")

public class BookController {
	
	//First Step Usually add this to link this controller with services :
	@Autowired
	BookService bookService;@RequestMapping("")
	
	
	//Second Steps : Routes
	public String home() {
		return "redirect:/books";
	}

	
	@RequestMapping("/books/{id}")
		// Model bech yhez data: 
	public String showOne(Model model,@PathVariable("id") Long id) {
		// Fetch the book by its ID and add it to the model
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		System.out.println(book);
		
		return "show.jsp";
	}
}
