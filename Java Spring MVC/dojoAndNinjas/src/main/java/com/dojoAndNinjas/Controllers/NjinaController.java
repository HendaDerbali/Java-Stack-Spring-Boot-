package com.dojoAndNinjas.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dojoAndNinjas.Services.DojoService;
import com.dojoAndNinjas.Services.NinjaService;
import com.dojoAndNinjas.models.Dojo;
import com.dojoAndNinjas.models.Ninja;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class NjinaController {
	
	// First Step Usually add this to link this controller with services :
			@Autowired
			NinjaService ninjaService;
			@Autowired
			DojoService dojoService;
			
		
			
 // Second Steps : Routes
			
			
			
			// ? Create : ( Form Many to one with multi select List on One )

			@RequestMapping("/ninjas/new")
			public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
			 //add allDojos () to fetch all Dojos in order to display them in select list
				List<Dojo> dojos = dojoService.allDojos();
				System.out.println(dojos);
				model.addAttribute("dojos", dojos); 

				return "ninja.jsp";
			}

			@PostMapping("/addNinja")
			public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
				if (result.hasErrors()) {
					return "ninja.jsp";
				} else {
					ninjaService.createNinja(ninja);
					return "redirect:/";
				}
			}
			

	}