package com.kh013j.model.service;

import com.kh013j.model.domain.Category;
import com.kh013j.model.domain.Dish;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.service.comparator.CaloriesComparator;
import com.kh013j.model.service.comparator.PreparingTimeComparator;
import com.kh013j.model.service.comparator.PriceComparator;
import com.kh013j.model.service.interfaces.DishService;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DishServiceImplTest {
    private static EmbeddedPostgres embeddedPostgres;

    @Autowired
    private DishService dishService;

    private Category soupsCategory = new Category(1, "Soups");
    private Category mealsCategory = new Category(2, "Meals");
    private Category drinksCategory = new Category(3, "Drinks");
    private Category desertsCategory = new Category(4, "Deserts");

    private List<Dish> categoryDishes;

    @BeforeClass
    public static void setUp() throws Exception {
        CaffinoApplicationTestConfiguration caffinoApplicationTestConfiguration = new CaffinoApplicationTestConfiguration();
        embeddedPostgres = caffinoApplicationTestConfiguration.startPostgres();
    }

    @Test
    public void create() throws Exception {
        Dish dish = new Dish();

        // creating a dish without id
        dish.setName("Tekila");
        dish.setDescription("This'll blow away your mind");
        dish.setWeight(250);
        dish.setCalories(500);
        dish.setPreparingtime(5);
        dish.setPicture("some_pic.jpej");
        dish.setPrice(10);
        dish.setCategory(drinksCategory);
        dish.setAvailability(true);

        // valid insert
        Dish createdDish = dishService.create(dish);

        Assert.assertThat(createdDish.getName(), is(equalTo(dish.getName())));
    }

    @Test(expected = Exception.class)
    public void tryToCreate() {
        dishService.create(new Dish());
    }

    @Test
    public void findById() throws Exception {
        Dish dish = new Dish();

        dish.setName("Mexico Tekila");
        dish.setDescription("This will burn Your stomach");
        dish.setWeight(250);
        dish.setCalories(500);
        dish.setPreparingtime(5);
        dish.setPicture("mexico_pic.jpej");
        dish.setPrice(12);
        dish.setCategory(drinksCategory);
        dish.setAvailability(true);

        Dish createdDish = dishService.create(dish);

        //search a dish by id of a created dish
        Dish foundDish = dishService.findById(createdDish.getId());

        assertEquals(dish, foundDish);
    }

    public void tryToFindById() {
        assertNull(dishService.findById(-1));
    }

    @Test
    public void findAllDishByCategoryOrderByPrice() throws Exception {
        categoryDishes = dishService.findAllDishByCategory(soupsCategory);
        categoryDishes.sort(new PriceComparator());
        // check min price
        Assert.assertTrue(categoryDishes.get(0).getPrice() == 70);
        // check max price
        Assert.assertTrue(categoryDishes.get(categoryDishes.size() - 1).getPrice() == 80);

        categoryDishes = dishService.findAllDishByCategory(mealsCategory);
        categoryDishes.sort(new PriceComparator());
        // check min price
        Assert.assertTrue(categoryDishes.get(0).getPrice() == 10);
        // check max price
        Assert.assertTrue(categoryDishes.get(categoryDishes.size() - 1).getPrice() == 93);

        categoryDishes = dishService.findAllDishByCategory(drinksCategory);
        categoryDishes.sort(new PriceComparator());
        // check min price
        Assert.assertTrue(categoryDishes.get(0).getPrice() == 10);
        // check max price
        Assert.assertTrue(categoryDishes.get(categoryDishes.size() - 1).getPrice() == 12);

        categoryDishes = dishService.findAllDishByCategory(desertsCategory);
        categoryDishes.sort(new PriceComparator());
        System.out.println();
        // check min price
        Assert.assertTrue(categoryDishes.get(0).getPrice() == 6);
        // check max price
        Assert.assertTrue(categoryDishes.get(categoryDishes.size() - 1).getPrice() == 35);
    }

    @Test
    public void findAllDishByCategoryOrderByPreparingtime() throws Exception {
        categoryDishes = dishService.findAllDishByCategory(soupsCategory);
        categoryDishes.sort(new PreparingTimeComparator());
        // check min preparing time
        Assert.assertTrue(categoryDishes.get(0).getPreparingtime() == 2);
        // check max preparing time
        Assert.assertTrue(categoryDishes.get(categoryDishes.size() - 1).getPreparingtime() == 28);

        categoryDishes = dishService.findAllDishByCategory(mealsCategory);
        categoryDishes.sort(new PreparingTimeComparator());
        // check min preparing time
        Assert.assertTrue(categoryDishes.get(0).getPreparingtime() == 12);
        // check max preparing time
        Assert.assertTrue(categoryDishes.get(categoryDishes.size() - 1).getPreparingtime() == 20);

        categoryDishes = dishService.findAllDishByCategory(drinksCategory);
        categoryDishes.sort(new PreparingTimeComparator());
        // check min preparing time
        Assert.assertTrue(categoryDishes.get(0).getPreparingtime() == 5); //create method worked
        // check max preparing time
        Assert.assertTrue(categoryDishes.get(categoryDishes.size() - 1).getPreparingtime() == 25);

        categoryDishes = dishService.findAllDishByCategory(desertsCategory);
        categoryDishes.sort(new PreparingTimeComparator());
        // check min preparing time
        Assert.assertTrue(categoryDishes.get(0).getPreparingtime() == 15);
        // check max preparing time
        Assert.assertTrue(categoryDishes.get(categoryDishes.size() - 1).getPreparingtime() == 40);
    }

    @Test
    public void findAllDishByCategoryOrderByCalories() throws Exception {
        categoryDishes = dishService.findAllDishByCategory(soupsCategory);
        categoryDishes.sort(new CaloriesComparator());
        // check min calories
        Assert.assertTrue(categoryDishes.get(0).getCalories() == 400);
        // check max calories
        Assert.assertTrue(categoryDishes.get(categoryDishes.size() - 1).getCalories() == 1010);

        categoryDishes = dishService.findAllDishByCategory(mealsCategory);
        categoryDishes.sort(new CaloriesComparator());
        // check min calories
        Assert.assertTrue(categoryDishes.get(0).getCalories() == 1300);
        // check max calories
        Assert.assertTrue(categoryDishes.get(categoryDishes.size() - 1).getCalories() == 1400);

        categoryDishes = dishService.findAllDishByCategory(drinksCategory);
        categoryDishes.sort(new CaloriesComparator());
        // check min calories
        Assert.assertTrue(categoryDishes.get(0).getCalories() == 500); // create method worked
        // check max calories
        Assert.assertTrue(categoryDishes.get(categoryDishes.size() - 1).getCalories() == 950);

        categoryDishes = dishService.findAllDishByCategory(desertsCategory);
        categoryDishes.sort(new CaloriesComparator());
        // check min price
        Assert.assertTrue(categoryDishes.get(0).getCalories() == 1000);
        // check max price
        Assert.assertTrue(categoryDishes.get(categoryDishes.size() - 1).getCalories() == 1450);
    }

    @Test
    public void findAllDishByCategory() throws Exception {
        Assert.assertFalse(dishService.findAllDishByCategory(soupsCategory).isEmpty());

        Assert.assertNotNull(dishService.findAllDishByCategory(mealsCategory));

        Assert.assertNotNull(dishService.findAllDishByCategory(drinksCategory));

        Assert.assertTrue(dishService.findAllDishByCategory(desertsCategory).size() >= 1);
    }

    @Test
    public void delete() throws DishNotFound {
        Dish firstDish = new Dish(1L, "White corn guacamole", "Diced avocado, sweet white corn, black beans, jicama, bell peppers, fresh cilantro and serrano peppers. Served with housemade blue & white corn tortilla chips.",
                200, 1000, 40, 3, desertsCategory, "/images/White%20corn%20guacamole.jpg", true);

        Dish deletedDish = dishService.delete(1L);

        assertEquals(deletedDish, firstDish);
    }

    @Test(expected = DishNotFound.class)
    public void tryToDelete() throws DishNotFound {
        dishService.delete(-1);
    }

    @Test
    public void findAll() throws Exception {
        Assert.assertTrue(dishService.findAll().size() > 0);
    }

    @Test
    public void update() throws DishNotFound {
        String name = "Voila tekila";

        Dish updatedDish = dishService.findById(2L);
        Dish dish = new Dish(updatedDish);

        dish.setName(name);

        updatedDish = dishService.update(dish);

        Assert.assertThat(updatedDish.getName(), is(equalTo(name)));
    }

    @Test(expected = DishNotFound.class)
    public void tryToUpdate() throws DishNotFound {
        Dish updatedDish = dishService.findById(3L);
        updatedDish.setId(-1L);

        Dish dish = dishService.update(updatedDish);
    }

    @Test(expected = Exception.class)
    public void tryWrongPrice(){
        Dish dish = new Dish();

        dish.setName("Red vine");
        dish.setDescription("Gorgeous flavour");
        dish.setWeight(200);
        dish.setCalories(450);
        dish.setPreparingtime(5);
        dish.setPicture("vino_pic.jpej");
        dish.setPrice(-12);
        dish.setCategory(drinksCategory);
        dish.setAvailability(true);

        dishService.create(dish);
    }

    // data validation
    @Test(expected = Exception.class)
    public void tryWrongWeight(){
        Dish dish = new Dish();

        dish.setName("Red vine");
        dish.setDescription("Gorgeous flavour");
        dish.setWeight(-200);
        dish.setCalories(450);
        dish.setPreparingtime(5);
        dish.setPicture("vino_pic.jpej");
        dish.setPrice(12);
        dish.setCategory(drinksCategory);
        dish.setAvailability(true);

        dishService.create(dish);
    }

    @Test(expected = Exception.class)
    public void tryWrongPreparingTime(){
        Dish dish = new Dish();

        dish.setName("Red vine");
        dish.setDescription("Gorgeous flavour");
        dish.setWeight(200);
        dish.setCalories(450);
        dish.setPreparingtime(-5);
        dish.setPicture("vino_pic.jpej");
        dish.setPrice(12);
        dish.setCategory(drinksCategory);
        dish.setAvailability(true);

        dishService.create(dish);
    }

    @Test(expected = Exception.class)
    public void tryWrongCalories(){
        Dish dish = new Dish();

        dish.setName("Red vine");
        dish.setDescription("Gorgeous flavour");
        dish.setWeight(200);
        dish.setCalories(-450);
        dish.setPreparingtime(5);
        dish.setPicture("vino_pic.jpej");
        dish.setPrice(12);
        dish.setCategory(drinksCategory);
        dish.setAvailability(true);

        dishService.create(dish);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        embeddedPostgres.stop();
    }
}