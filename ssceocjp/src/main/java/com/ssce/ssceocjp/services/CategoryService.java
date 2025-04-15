package com.ssce.ssceocjp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssce.ssceocjp.model.Category;
import com.ssce.ssceocjp.repository.CategoryRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {

    @Autowired CategoryRepository categoryRepository;

    public Category addCategory(Category category){
        if(categoryRepository.existsByCategoryAndSubCategory(category.getCategory(),category.getSubCategory())){
            throw new EntityExistsException("Category already exists");
        }
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long categoryId){
        return categoryRepository.findById(categoryId).orElseThrow(EntityNotFoundException::new);
    }

    public List<Category> getSubCategoriesByCategory(String category){
        return categoryRepository.findByCategory(category);
    }

    public Category updateCategory(Long categeoryId, Category category){
        category.setCategoryId(categeoryId);
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long categoryId){
        categoryRepository.deleteById(categoryId);
    }

}
