package com.dojoAndNinjas.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojoAndNinjas.models.Ninja;

public interface NinjaRepository extends  CrudRepository<Ninja, Long> {

	
	// this method retrieves all the books from the database
    //Mondatory
	List<Ninja> findAll();
	
	//Optional
    // this method finds books with descriptions containing the search string
    List<Ninja> findByFirstNameContaining(String search);

}



