package com.omikujiForm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class MainController {

	@RequestMapping("/omikuji")
	public String omikuji() {
		return "omikuji.jsp";
	}

	@RequestMapping("/send")
	public String send(@RequestParam(value = "city") String city,
			@RequestParam(value = "person") String person,
			@RequestParam(value = "number") String number,
			HttpSession session) {
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("number", number);

		return "redirect:/show";
	}

	@RequestMapping("/show")
	public String show(HttpSession session, Model model) {
		return "show.jsp";
	}

}
