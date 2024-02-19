package com.dojoAndNinjas.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dojoAndNinjas.Services.DojoService;
import com.dojoAndNinjas.Services.NinjaService;
import com.dojoAndNinjas.models.Dojo;
import com.dojoAndNinjas.models.Ninja;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class DojoController {
	
	// First Step Usually add this to link this controller with services :
	@Autowired
	NinjaService ninjaService;
	@Autowired
	DojoService dojoService;
	
		
		// Route For Testing 
    	@RequestMapping("")
   	 	public String index() {
        return "redirect:/dojos/new";
    	}
	
		
		// Second Steps : Routes
		
		// ? Create :

		@RequestMapping("/dojos/new")
		public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
			return "dojo.jsp";
		}

		@PostMapping("/addDojo")
		public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
			if (result.hasErrors()) {
				return "dojo.jsp";
			} else {
				dojoService.createDojo(dojo);
				return "redirect:/";
			}
		}
		
		// ? Get One By id
				@RequestMapping("/dojos/{id}")
				// Model bech yhez data:
				public String showOne(Model model, @PathVariable("id") Long id) {
					
					//add allNinjas () to fetch all ninjas related of one dojo
					List<Ninja> ninjas = ninjaService.allNinjas();
					System.out.println(ninjas);
					
					// Fetch the book by its ID and add it to the model
					Dojo dojo = dojoService.findDojo(id);
					model.addAttribute("dojo", dojo);
					System.out.println(dojo); // just to show my console

					return "dojoPage.jsp";
				}
		

}