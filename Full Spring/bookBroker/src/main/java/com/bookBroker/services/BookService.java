package com.bookBroker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bookBroker.models.Book;
import com.bookBroker.repositories.BookRepository;

@Service
public class BookService {

	// adding the Book repository as a dependency
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// returns all the Books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	// creates a Book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}

	// retrieves a Book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) { // isPresent() : method to check if our object exists.
			return optionalBook.get();
		} else {
			return null;
		}
	}

	// update a Book
	public Book updateBook(Book b) {
		return bookRepository.save(b);
	}

	// find by containing
	public List<Book> BooksContaining(String search) {
		return bookRepository.findByTitleContaining(search);
	}

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

}