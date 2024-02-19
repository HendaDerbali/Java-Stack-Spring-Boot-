package com.dojoAndNinjas.Repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojoAndNinjas.models.Dojo;


public interface DojoRepository extends  CrudRepository<Dojo, Long> {

	
	// this method retrieves all the books from the database
    //Mondatory
	List<Dojo> findAll();
	
	//Optional
    // this method finds books with descriptions containing the search string
    List<Dojo> findByNameContaining(String search);
}
