package com.ssce.ssceocjp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ssce.ssceocjp.model.Category;
import com.ssce.ssceocjp.model.Question;
import com.ssce.ssceocjp.repository.QuestionRepository;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question addQuestion(Question question){
        return questionRepository.save(question);
    }

    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByCategory(Category category){
        return questionRepository.findByCategory(category);
    }

    public List<Question> getQuestionsByCategoryAndSubCategory(int page, int size,String category, String subCategory){
        PageRequest pageable = PageRequest.of(page, size);
        return questionRepository.findByCategoryAndSubCategory(category,subCategory,pageable);
    }

    public Page<Question> getQuestionsPaginated(int page, int size, String category, String subCategory) {
        PageRequest pageable = PageRequest.of(page, size);
        return questionRepository.findAll(pageable);
    }

}
