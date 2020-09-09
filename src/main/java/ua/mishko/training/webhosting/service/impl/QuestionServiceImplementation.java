package ua.mishko.training.webhosting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mishko.training.webhosting.domain.Question;
import ua.mishko.training.webhosting.repository.CategoryRepository;
import ua.mishko.training.webhosting.repository.QuestionRepository;
import ua.mishko.training.webhosting.service.QuestionService;

import java.util.List;

@Service
public class QuestionServiceImplementation implements QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImplementation(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }
}
