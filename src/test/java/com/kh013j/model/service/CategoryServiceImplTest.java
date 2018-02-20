package com.kh013j.model.service;

import com.kh013j.model.domain.Category;
import com.kh013j.model.exception.CategoryNotFound;
import com.kh013j.model.service.interfaces.CategoryService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    private static EmbeddedPostgres embeddedPostgres;

    @Autowired
    private CategoryService categoryService;

    @BeforeClass
    public static void setUp() throws Exception {
        CaffinoApplicationTestConfiguration caffinoApplicationTestConfiguration = new CaffinoApplicationTestConfiguration();
        embeddedPostgres = caffinoApplicationTestConfiguration.startPostgres();
    }

    @Test
    public void create() {
        Category category = new Category();
        category.setName("For kids");

        Category createdCategory = categoryService.create(category);
        assertEquals(createdCategory.getName(), category.getName());
    }

    @Test(expected = Exception.class)
    public void tryCreate() {
        categoryService.create(new Category());
    }

    @Test
    public void delete() throws CategoryNotFound {
        Category firstCategory = new Category(1, "Soups");

        Category deletedCategory = categoryService.delete(1L);

        assertEquals(firstCategory, deletedCategory);
    }

    @Test(expected = CategoryNotFound.class)
    public void tryDelete() throws CategoryNotFound {
        categoryService.delete(-1L);
    }

    @Test
    public void update() throws CategoryNotFound {
        String name = "Pancakes";

        Category category = new Category(2, name);
        Category updatedCategory = categoryService.update(category);

        assertEquals(updatedCategory.getName(), name);
    }

    @Test
    public void tryUpdate() throws CategoryNotFound {
        String name = "Pancakes";

        Category category = new Category(2, name);
        Category updatedCategory = categoryService.update(category);

        assertEquals(updatedCategory.getName(), name);
    }

    @Test
    public void findCategoryByName() {
        String name = "Meals";
        Category category = new Category(2, name);

        Category foundCategory = categoryService.findCategoryByName(name);

        assertEquals(foundCategory, category);
    }

    @Test
    public void tryFindCategoryByName(){

    }

    @Test
    public void findAll() {
    }

    @AfterClass
    public static void tearDown() throws Exception {
        embeddedPostgres.stop();
    }
}