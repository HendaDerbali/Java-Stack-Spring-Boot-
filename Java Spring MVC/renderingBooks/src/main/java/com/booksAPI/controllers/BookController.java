package com.booksAPI.controllers;

import java.util.List;

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
	BookService bookService;
	
	//Second Steps : Routes
	
	@RequestMapping("")
	public String home() {
		return "redirect:/books";
	}

	
	// ?Get All
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		System.out.println(books); // just to show my console

		return "index.jsp";
	}
	
	
	// ? Get One By id
	@RequestMapping("/books/{id}")
		// Model bech yhez data: 
	public String showOne(Model model,@PathVariable("id") Long id) {
		// Fetch the book by its ID and add it to the model
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		System.out.println(book); // just to show my console
		
		return "show.jsp";
	}
}
