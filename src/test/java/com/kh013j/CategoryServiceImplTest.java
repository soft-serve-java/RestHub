package com.kh013j;

import com.kh013j.model.domain.Category;
import com.kh013j.model.exception.CategoryNotFound;
import com.kh013j.model.service.interfaces.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    public void create() {
        Category category = new Category();
        category.setName("For kids");

        Category createdCategory = categoryService.create(category);
        assertEquals(createdCategory.getName(), category.getName());
    }

    @Test(expected = Exception.class)
    public void tryToCreate() {
        categoryService.create(new Category());
    }

    @Test
    public void delete() throws CategoryNotFound {
        Category category = new Category(5, "Summer menu");

        Category createdCategory = categoryService.create(category);

        Category deletedCategory = categoryService.delete(createdCategory.getId());

        Assert.assertNull(categoryService.findCategoryByName(deletedCategory.getName()));
    }

    @Test(expected = Exception.class)
    public void tryToDelete() throws CategoryNotFound {
        categoryService.delete(-1L);
    }

    @Test
    public void update() {
        String name = "Pancakes";

        Category category = new Category();
        category.setName(name);

        categoryService.create(category);

        Category foundCategory = categoryService.findCategoryByName(name);
        foundCategory.setName("Vegetarian");

        Category updatedCategory = categoryService.update(foundCategory);

        Category foundUpdatedCategory = categoryService.findCategoryByName(updatedCategory.getName());

        assertEquals(foundCategory, foundUpdatedCategory);
    }

    @Test
    public void tryToUpdate() {
        String name = "Pancakes";

        Category category = new Category(2, name);
        Category updatedCategory = categoryService.update(category);

        assertEquals(updatedCategory.getName(), name);
    }

    @Test
    public void findCategoryByName() {
        // create in before
        String name = "Bakery";
        Category category = new Category();
        category.setName(name);

        Category createdCategory = categoryService.create(category);

        Category foundCategory = categoryService.findCategoryByName(name);

        assertEquals(foundCategory, createdCategory);
    }

    public void tryToFindCategoryByName(){
        Assert.assertNull(categoryService.findCategoryByName(""));
    }

    @Test
    public void findAll() {
        Assert.assertTrue(categoryService.findAll().size() >= 4);
    }
}