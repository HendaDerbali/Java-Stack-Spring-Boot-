package com.booksAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.booksAPI.models.Book;
import com.booksAPI.services.BookService;

import jakarta.validation.Valid;

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
	
	
	// ? Create :
	
	//step01 : Use the @ModelAttribute annotation to add an empty book object to the view model in the GET route that renders the form.
	//Render the view (new.jsp)
	
	@RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "new.jsp";
    }
	
	//step03 : Pass the filled book from the view model into the POST method
	//Save the new book to the database
	
	 @PostMapping("/books")
	    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
	        if (result.hasErrors()) {
	            return "new.jsp";
	        } else {
	            bookService.createBook(book);
	            return "redirect:/books";
	        }
	    }
	 
	 
	 //? Edit : 

	     @RequestMapping("/books/{id}/edit")
	     public String edit(@PathVariable("id") Long id, Model model) {
	         Book book = bookService.findBook(id);
	         model.addAttribute("book", book);
	         return "edit.jsp";
	     }
	     
	     @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
	     public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
	         if (result.hasErrors()) {
	             model.addAttribute("book", book);
	             return "edit.jsp";
	         } else {
	             bookService.updateBook(book);
	             return "redirect:/books";
	         }
	     }
	 }




