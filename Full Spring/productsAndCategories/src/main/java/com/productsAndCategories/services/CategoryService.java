package com.productsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.productsAndCategories.models.Category;
import com.productsAndCategories.models.Product;
import com.productsAndCategories.repositories.CategoryRepository;

@Service
public class CategoryService {

	// adding the Product repository as a dependency
	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	// returns all the Categories
	public List<Category> allCategorys() {
		return categoryRepository.findAll();
	}

	// List Of Categories that not associated to the Product
	public List<Category> getUnassignedCategories(Product product) {
		return categoryRepository.findByProductsNotContains(product);
	}

	// creates a Category
	public Category createCategory(Category b) {
		return categoryRepository.save(b);
	}

	// retrieves a Category
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) { // isPresent() : method to check if our object exists.
			return optionalCategory.get();
		} else {
			return null;
		}
	}

	// update a Category
	public Category updateCategory(Category b) {
		return categoryRepository.save(b);
	}

	// find by containing
	public List<Category> CategorysContaining(String search) {
		return categoryRepository.findByNameContaining(search);
	}

	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}

}