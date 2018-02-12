package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.Category;
import com.kh013j.model.exception.CategoryNotFound;

import java.util.List;

public interface CategoryService {
    Category delete(long id) throws CategoryNotFound;

    Category create(Category category);

    Category update(Category category) throws CategoryNotFound;

    List findAll();

    Category findCategoryByName(String name);
}
