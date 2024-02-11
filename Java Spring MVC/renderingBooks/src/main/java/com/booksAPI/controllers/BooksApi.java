package com.booksAPI.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booksAPI.models.Book;
import com.booksAPI.services.BookService;

@RestController
public class BooksApi {
	
	//first steps : code to connect with our service :private final BookService bookService
	private final BookService bookService;
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    
    // ? GetAll Api : 
    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }
    
    //? Create
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title,
    		@RequestParam(value="description") String desc,
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    //? Get one
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }
    
    
    //? Update one
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {       
    	
    	Book book = new Book(title, desc, lang, numOfPages);
    	book.setId(id);
    	
        book = bookService.updateBook(book);
        return book;
    }
    
    //delete one :
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
    

}
