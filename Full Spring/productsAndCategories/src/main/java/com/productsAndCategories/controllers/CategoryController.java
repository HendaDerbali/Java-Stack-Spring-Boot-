package com.productsAndCategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.productsAndCategories.models.Category;
import com.productsAndCategories.services.CategoryService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")

public class CategoryController {

	// First Step Usually add this to link this controller with services :
	@Autowired
	CategoryService categoryService;

	// Second Steps : Routes

	// ? Create :

	@RequestMapping("/categories/new")
	public String newDojo(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}

	@PostMapping("/addCategory")
	public String create(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "newCategory.jsp";
		} else {
			categoryService.createCategory(category);
			return "redirect:/";
		}
	}

}
