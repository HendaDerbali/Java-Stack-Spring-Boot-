package com.bookClub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookClub.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	// this method retrieves all the books from the database
	// Mondatory
	List<Book> findAll();

	// Optional
	// this method finds books with descriptions containing the search string
	List<Book> findByTitleContaining(String search);
}
