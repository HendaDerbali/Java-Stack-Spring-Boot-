package com.productsAndCategories.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.productsAndCategories.models.Category;
import com.productsAndCategories.models.Product;
import com.productsAndCategories.services.CategoryService;
import com.productsAndCategories.services.ProductService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")

public class ProductController {

	// First Step Usually add this to link this controller with services :
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;

	// Second Steps : Routes

	// ? Create :

	@RequestMapping("/products/new")
	public String newDojo(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}

	@PostMapping("/addProduct")
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "newProduct.jsp";
		} else {
			productService.createProduct(product);
			return "redirect:/";
		}
	}

	// ? Display All Products and Categories :
	@RequestMapping("")
	public String displayAllProductsAndCategories(@ModelAttribute("product") Product product,
			@ModelAttribute("category") Category category, Model model) {

		List<Product> products = productService.allProducts();
		List<Category> categories = categoryService.allCategorys();
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);

		return "index.jsp";
	}

	// ? Get One Product and Associate products to it :
	@RequestMapping("/products/{id}")
	public String showOneProdcut(@PathVariable("id") Long id, Model model) {
		Product product = productService.findProduct(id);
		List<Category> categories = categoryService.allCategorys();
		// Unassigned categories to be displayed in select list
		model.addAttribute("unassignedCategories", categoryService.getUnassignedCategories(product));

		model.addAttribute("product", product);
		model.addAttribute("categories", categories);
		return "showOneProduct.jsp";
	}
	
	// Associate Categories to a product
	@PostMapping("/editProduct/{id}")
	public String addCategoryToProduct(@PathVariable("id") Long id, @RequestParam(value = "categoryId") Long categoryId,
			Model model) {
		Product product = productService.findProduct(id);
		Category category = categoryService.findCategory(categoryId);
		// Display all categories that are associated to the actual product, and add the new category
		product.getCategories().add(category);
		productService.updateProduct(product); // update
		return "redirect:/products/" + id;
	}

}
