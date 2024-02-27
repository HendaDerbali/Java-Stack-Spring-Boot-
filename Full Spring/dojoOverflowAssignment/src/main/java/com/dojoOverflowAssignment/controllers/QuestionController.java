package com.dojoOverflowAssignment.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dojoOverflowAssignment.models.Answer;
import com.dojoOverflowAssignment.models.Question;
import com.dojoOverflowAssignment.models.Tag;
import com.dojoOverflowAssignment.services.AnswerService;
import com.dojoOverflowAssignment.services.QuestionService;
import com.dojoOverflowAssignment.services.TagService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class QuestionController {
	
	// First Step Usually add this to link this controller with services :
	@Autowired
	QuestionService questionService;
	@Autowired
	TagService tagService;
	@Autowired
	AnswerService answerService;
	
	

	// Second Steps : Routes

	// ? Display All Products and Categories :
	@RequestMapping("")
	public String displayAll(@ModelAttribute("question") Question question, @ModelAttribute("tag") Tag category,
			Model model) {

		List<Question> questions = questionService.allQuestions();
		List<Tag> tags = tagService.allTags();
		model.addAttribute("questions", questions);
		model.addAttribute("tags", tags);

		return "index.jsp";
	}

	// ? Create :

	@RequestMapping("/questions/new")
	public String newDojo(@ModelAttribute("question") Question question) {
		return "newQuestion.jsp";
	}

	@PostMapping("/addQuestion")
	public String addQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result,
			@RequestParam("listOfTags") String listOfTags, RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "newQuestion.jsp";
		}

		List<Tag> questionTags = checkTags(listOfTags);

		if (questionTags == null || questionTags.size() > 3) {
			redirectAttributes.addFlashAttribute("error", "The number of tags must be between 1 and 3");
			return "redirect:/questions/new";
		}

		question.setTags(questionTags);
		questionService.createQuestion(question);

		return "redirect:/";
	}

	private List<Tag> checkTags(String tags) {
		if (tags.length() > 0) {
			ArrayList<Tag> questionTags = new ArrayList<Tag>();
			String[] tagList = tags.split(",");
			for (String tagString : tagList) {
				Tag tag = tagService.findByName(tagString.toLowerCase().strip());
				if (tag == null) {
					tag = new Tag(tagString.toLowerCase().strip());
					tagService.createTag(tag);
				}
				questionTags.add(tag);
			}
			return questionTags;
		}
		return null;
	}

	// Show One Question , and add aswers to it :
	@GetMapping("/questions/{id}")
	public String viewQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("answer") Answer answer) {
		model.addAttribute("question", questionService.findQuestion(id));
		return "viewQuestion.jsp";
	}

	@PostMapping("/questions/{questionId}/answers/new")
	public String newAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result,
			@PathVariable("questionId") Long id, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("question", questionService.findQuestion(id));
			return "viewQuestion.jsp";
		}

		answer.setQuestion(questionService.findQuestion(id));
		answerService.createAnswer(answer);

		return "redirect:/questions/"+id;
	}
}
