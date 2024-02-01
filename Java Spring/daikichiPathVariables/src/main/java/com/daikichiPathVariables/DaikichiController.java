package com.daikichiPathVariables;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	 @RequestMapping("/travel/{travelCountry}")
	   public String travel(@PathVariable("travelCountry") String travelCountry){
	    	return "Congratulations! You will soo, travel to  " + travelCountry + " !" ;
	   }
	 
	 @RequestMapping("/lotto/{lottoId}")
	   public String lotto(@PathVariable("lottoId") Integer lottoId){
		 if (lottoId % 2 != 0) {
		    	return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends." ;

		 }
		 else 
		 
	    	return "You will take a grand journey in the near future, but be weary of tempting offers" ;
	   }
	
}
