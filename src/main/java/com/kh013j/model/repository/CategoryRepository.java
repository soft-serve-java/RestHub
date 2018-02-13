package com.kh013j.model.repository;

import com.kh013j.model.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryByName(String name);
}
