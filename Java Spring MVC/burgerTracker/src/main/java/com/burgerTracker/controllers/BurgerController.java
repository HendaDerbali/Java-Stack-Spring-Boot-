package com.burgerTracker.controllers;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.burgerTracker.models.Burger;
import com.burgerTracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class BurgerController {

	@Autowired
	BurgerService burgerService;


	// ? Create + Get All ( in the same jsp page):

	@GetMapping("")
	public String home(@ModelAttribute("burger") Burger burger, Model model) {
		List<Burger> burgers = burgerService.allBurgers();
		model.addAttribute("burgers", burgers);
		return "index.jsp";
	}


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
	
	
	// Edit Burger:
	  @RequestMapping("/edit/{id}")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Burger burger = burgerService.findBurger(id);
	        model.addAttribute("burger", burger);
	        return "edit.jsp";
	    }
	  
	  @RequestMapping(value="/editBurger/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            model.addAttribute("burger", burger);
	            return "edit.jsp";
	        } else {
	        	burgerService.updateBurger(burger);
	            return "redirect:/";
	        }
	    }
	    
	    

}
