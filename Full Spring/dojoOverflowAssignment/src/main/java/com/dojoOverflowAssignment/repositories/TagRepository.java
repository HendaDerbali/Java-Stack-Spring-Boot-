package com.dojoOverflowAssignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojoOverflowAssignment.models.Tag;


@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

	// this method retrieves all the books from the database
	// Mondatory
	List<Tag> findAll();
	
	//Optional
    // this method finds books with descriptions containing the search string
    List<Tag> findByNameContaining(String search);
    
    //
    Tag findByNameIs(String subject);

}