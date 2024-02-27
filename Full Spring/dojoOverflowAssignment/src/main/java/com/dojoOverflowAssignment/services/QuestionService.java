package com.dojoOverflowAssignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojoOverflowAssignment.models.Question;
import com.dojoOverflowAssignment.repositories.QuestionRepository;

@Service
public class QuestionService {
// adding the Question repository as a dependency
private final QuestionRepository questionRepository;

public QuestionService(QuestionRepository questionRepository) {
    this.questionRepository = questionRepository;
}
// returns all the Questions
public List<Question> allQuestions() {
    return questionRepository.findAll();
}
// creates a Question
public Question createQuestion(Question b) {
    return questionRepository.save(b);
}
// retrieves a Question
public Question findQuestion(Long id) {
    Optional<Question> optionalQuestion = questionRepository.findById(id);
    if(optionalQuestion.isPresent()) {  //isPresent() : method to check if our object exists.
        return optionalQuestion.get();
    } else {
        return null;
    }
}
 // update a Question
	  public Question updateQuestion(Question b) {
    return questionRepository.save(b);
}
	  
// // find by containing
//	  public List<Question> QuestionsContaining(String search) {
//    return questionRepository.findByTitleContaining(search);
//}
public void deleteQuestion(Long id) {
	questionRepository.deleteById(id);
}

}