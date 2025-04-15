package com.ssce.ssceocjp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssce.ssceocjp.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{
    public boolean existsByCategory(String category);
    public List<Category> findByCategory(String category);
    public boolean existsByCategoryAndSubCategory(String category,String subCategory);
}
