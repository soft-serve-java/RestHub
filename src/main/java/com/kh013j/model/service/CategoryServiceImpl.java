package com.kh013j.model.service;

import com.kh013j.model.domain.Category;
import com.kh013j.model.exception.CategoryNotFound;
import com.kh013j.model.repository.CategoryRepository;
import com.kh013j.model.service.interfaces.CategoryService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    @Override
    public Category findById(long id) throws CategoryNotFound {
        Category category = categoryRepository.findOne(id);

        if (category == null){
            throw new CategoryNotFound();
        }
        return category;
    }

    @Override
    @Transactional(rollbackFor = CategoryNotFound.class)
    public Category delete(long id) throws CategoryNotFound {
        Category deletedCategory = categoryRepository.findOne(id);

        if (deletedCategory == null)
            throw new CategoryNotFound();

        categoryRepository.delete(deletedCategory);
        return deletedCategory;
    }


    @Override
    @Transactional
    public Category findCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }

    @Override
    @Transactional
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
