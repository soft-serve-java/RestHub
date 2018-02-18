package com.kh013j.model.service;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DishServiceImplTest {

    private static EmbeddedPostgres embeddedPostgres;

    @BeforeClass
    public static void setUp() throws Exception {
        CaffinoApplicationTestConfiguration caffinoApplicationTestConfiguration = new CaffinoApplicationTestConfiguration();
        embeddedPostgres = caffinoApplicationTestConfiguration.startPostgres();
    }

    @Test
    public void create() throws Exception {
    }

    @Test
    public void findById() throws Exception {
    }

    @Test
    public void findAllDishByCategoryOrderByPrice() throws Exception {
    }

    @Test
    public void findAllDishByCategoryOrderByPreparingtime() throws Exception {
    }

    @Test
    public void findAllDishByCategoryOrderByCalories() throws Exception {
    }

    @Test
    public void findAllDishByCategory() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @AfterClass
    public static void tearDown() throws Exception {
        embeddedPostgres.stop();
    }
}