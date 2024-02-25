package com.bookClub.controllers;

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

import com.bookClub.models.Book;
import com.bookClub.models.User;
import com.bookClub.services.BookService;
import com.bookClub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class BookController {

	// First Step Usually add this to link this controller with services :
	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;

	// Second Step : Routes :

	// ? Create : ( Form Many to one with multi select List on One )

	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		// 3 session lines : to make bring the user in the session
		User user = userService.findById((Long) session.getAttribute("userId"));
		model.addAttribute("user", user);
		System.out.println(user);

		return "newBook.jsp";
	}

	@PostMapping("/addBook")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {

			return "newBook.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books/new";
		}
	}

	// ? Get One By id

	@GetMapping("/books/{id}")
	public String showPage(Model model, @PathVariable("id") Long id, HttpSession session) {
		// session lines : to make bring the user in the session
		if (session.getAttribute("userId") == null) {
			return "redirect:/books";
		}
		// 3 session lines : to make bring the user in the session
		User user = userService.findById((Long) session.getAttribute("userId"));
		model.addAttribute("user", user);
		System.out.println(user);

		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		System.out.println(book);

		return "showOneBook.jsp";
	}

	// ? Delete Book :
	@RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}

	// Edit Book :
	// ? Edit :

	@RequestMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		// Session
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		// 3 session lines : to make bring the user in the session
		User user = userService.findById((Long) session.getAttribute("userId"));
		model.addAttribute("user", user);
		System.out.println(user);

		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		System.out.println(book);

		return "editBook.jsp";
	}

	@RequestMapping(value = "/editBook/{bookId}", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model,
			HttpSession session) {
		// Session
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			model.addAttribute("book", book);
			return "editBook.jsp";
		} else {
			bookService.updateBook(book);
			return "redirect:/books";
		}
	}

}
