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
import org.springframework.web.bind.annotation.RequestMethod;

import com.dojoAndNinjas.Services.DojoService;
import com.dojoAndNinjas.Services.NinjaService;
import com.dojoAndNinjas.models.Dojo;

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
				return "redirect:/ninjas/new";
			}
		}
		
		// ? Get One By id
				@RequestMapping("/dojos/{id}")
				// Model bech yhez data:
				public String showOne(Model model, @PathVariable("id") Long id) {
					//no need to add a list of ninjas  , because the list already exists in model( it is the many)
					// Fetch the book by its ID and add it to the model
					Dojo dojo = dojoService.findDojo(id);
					model.addAttribute("dojo", dojo);
					System.out.println(dojo); // just to show my console

					return "dojoPage.jsp";
				}
		
				
		// ? Display All Dojo :
				@RequestMapping("/dojos")
				public String displayAllDojos(@ModelAttribute("dojo") Dojo dojo, Model model) {
					List<Dojo> dojos = dojoService.allDojos();
					model.addAttribute("dojos", dojos);
					return "displayAllDojo.jsp";
				}
				
		// ? Delete Dojo :
				@RequestMapping(value = "/deleteDojo/{id}", method = RequestMethod.DELETE)
				public String destroy(@PathVariable("id") Long id) {
					dojoService.deleteDojo(id);
					return "redirect:/";
				}
}