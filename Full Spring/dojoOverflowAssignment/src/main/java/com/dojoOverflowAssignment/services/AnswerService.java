package com.dojoOverflowAssignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojoOverflowAssignment.models.Answer;
import com.dojoOverflowAssignment.repositories.AnswerRepository;

@Service
public class AnswerService {

	// adding the Answer repository as a dependency
	private final AnswerRepository answerRepository;

	public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

	// returns all the Answers
	public List<Answer> allAnswers() {
		return answerRepository.findAll();
	}

	// creates a Answer
	public Answer createAnswer(Answer b) {
		return answerRepository.save(b);
	}

	// retrieves a Answer
	public Answer findAnswer(Long id) {
		Optional<Answer> optionalAnswer = answerRepository.findById(id);
		if (optionalAnswer.isPresent()) { // isPresent() : method to check if our object exists.
			return optionalAnswer.get();
		} else {
			return null;
		}
	}

	// update a Answer
	public Answer updateAnswer(Answer b) {
		return answerRepository.save(b);
	}


	public void deleteAnswer(Long id) {
		answerRepository.deleteById(id);
	}

}