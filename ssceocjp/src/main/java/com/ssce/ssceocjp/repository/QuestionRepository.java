package com.ssce.ssceocjp.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ssce.ssceocjp.model.Category;
import com.ssce.ssceocjp.model.Question;

public interface QuestionRepository extends JpaRepository<Question,Long>, PagingAndSortingRepository<Question,Long>{
    public List<Question> findByCategory(Category category);

    @Query("SELECT q FROM Question q JOIN q.category c WHERE c.category = :category AND c.subCategory = :subCategory")
    public List<Question> findByCategoryAndSubCategory(String category,String subCategory,Pageable pageable);

}
