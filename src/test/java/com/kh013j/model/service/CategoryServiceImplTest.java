package com.kh013j.model.service;

import com.kh013j.model.domain.Category;
import com.kh013j.model.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImplTest {

    @Mock
    CategoryRepository categoryRepository;

    @Mock
    Category category;

    @InjectMocks
    CategoryServiceImpl csi;


    @Test
    public void create() {

    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void findCategoryByName() {
    }

    @Test
    public void findAll() {
    }
}