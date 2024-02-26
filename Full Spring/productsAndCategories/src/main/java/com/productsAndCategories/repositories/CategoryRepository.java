package com.productsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.productsAndCategories.models.Category;
import com.productsAndCategories.models.Product;


public interface CategoryRepository extends  CrudRepository<Category, Long> {

	
	// this method retrieves all the books from the database
    //Mondatory
	List<Category> findAll();
	
	//Optional
    // this method finds books with descriptions containing the search string
    List<Category> findByNameContaining(String search);

	List<Category> findByProductsNotContains(Product product);
}