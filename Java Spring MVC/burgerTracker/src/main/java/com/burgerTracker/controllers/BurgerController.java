package com.burgerTracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.burgerTracker.models.Burger;
import com.burgerTracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class BurgerController {

	@Autowired
	BurgerService burgerService;


	// ? Create + Get All ( in the same jsp page):

	// step01 : Use the @ModelAttribute annotation to add an empty book object to
	// the view model in the GET route that renders the form.
	// Render the view (new.jsp)

   //?Get All in the same page as Form
	@GetMapping("")
	public String home(@ModelAttribute("burger") Burger burger, Model model) {
		List<Burger> burgers = burgerService.allBurgers();
		model.addAttribute("burgers", burgers);
		return "index.jsp";
	}

	// step03 : Pass the filled book from the view model into the POST method
	// Save the new book to the database


	// Form in the same page as  Get All
	@PostMapping("/addBurger")
	public String home(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Burger> burgers = burgerService.allBurgers();
			model.addAttribute("burgers", burgers);
			return "index.jsp";
		}
		burgerService.createBurger(burger);
		return "redirect:/";
	}

}
