package com.kh013j;

import com.kh013j.model.domain.Category;
import com.kh013j.model.domain.Dish;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.repository.DishRepository;
import com.kh013j.model.service.interfaces.DishService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DishServiceImplTest {
    @Autowired
    private DishService dishService;

    @Autowired
    private DishRepository dishRepository;

    private Category soupsCategory = new Category(1, "Soups");
    private Category mealsCategory = new Category(2, "Meals");
    private Category drinksCategory = new Category(3, "Drinks");
    private Category desertsCategory = new Category(4, "Deserts");

    private List<Category> categories = Arrays.asList(soupsCategory, mealsCategory, drinksCategory, desertsCategory);
    private List<Dish> categoryDishes;
    private List<Dish> dishes = new ArrayList<>();

    @Before
    public void initialize() {
        dishes.addAll(Arrays.asList(
                (new Dish(1L, "White corn guacamole",
                        "Diced avocado, sweet white corn, black beans.",
                        200, 1000, 40, new BigDecimal(3), soupsCategory, "guacamole.jpg", true)),
                (new Dish(2L, "Camole",
                        "Diced avocado, sweet white corn, black beans.",
                        250, 1200, 10, new BigDecimal(33), soupsCategory, "pic.jpg", true)),
                (new Dish(3L, "Guacamole",
                        "Black beans.",
                        430, 1400, 20, new BigDecimal(56), soupsCategory, "pop.jpg", true)),
                (new Dish(4L, "Tiramisu",
                        "Soft.",
                        730, 1341, 26, new BigDecimal(39), desertsCategory, "p.jpg", true)),
                (new Dish(5L, "Tortinni",
                        "Delicious.",
                        330, 1909, 27, new BigDecimal(60), desertsCategory, "op.jpg", true)),
                (new Dish(6L, "Our desert",
                        "From love",
                        230, 1467, 29, new BigDecimal(34), desertsCategory, "h.jpg", true)),
                (new Dish(7L, "Gua mole",
                        "Red beans.",
                        230, 1348, 23, new BigDecimal(39), mealsCategory, "po.jpg", true)),
                (new Dish(8L, "Mole",
                        "Beans.",
                        530, 1906, 22, new BigDecimal(6), mealsCategory, "op.jpg", true)),
                (new Dish(9L, "Dishy-Issy",
                        "Different beans.",
                        730, 1409, 25, new BigDecimal(66), mealsCategory, "p.jpg", true)),
                (new Dish(10L, "Milk shake",
                        "Tasty drink",
                        521, 1317, 13, new BigDecimal(8), drinksCategory, "milk.jpg", true)),
                (new Dish(11L, "Strawberry cocktail",
                        "Tasty strawberry flavour",
                        580, 1005, 14, new BigDecimal(9), drinksCategory, "straw.jpg", true)),
                (new Dish(12L, "Blackberry cocktail",
                        "Tasty blackberry flavour",
                        570, 1404, 12, new BigDecimal(11), drinksCategory, "black.jpg", true))));

        for (Dish dish : dishes) {
            dishService.create(dish);
        }
    }

    @Test
    public void create() {
        Dish dish = new Dish();

        // creating a dish without id
        dish.setName("Tekila");
        dish.setDescription("This'll blow away your mind");
        dish.setWeight(250);
        dish.setCalories(500);
        dish.setPreparingtime(5);
        dish.setPicture("some_pic.jpej");
        dish.setPrice(new BigDecimal(10));
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
    public void findById() {
        Dish dish = new Dish();

        dish.setName("Mexico Tekila");
        dish.setDescription("This will burn Your stomach");
        dish.setWeight(250);
        dish.setCalories(500);
        dish.setPreparingtime(5);
        dish.setPicture("mexico_pic.jpej");
        dish.setPrice(new BigDecimal(12));
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
    public void findAllDishByCategoryOrderByPrice() {
        for (Category category : categories) {
            categoryDishes = dishService.findAllAvailableDishByCategoryOrderByPrice(category);

            Dish minPriceDish = categoryDishes.stream().min(Comparator.comparing(Dish::getPrice)).get();
            assertEquals(categoryDishes.get(0), minPriceDish);

            Dish maxPriceDish = categoryDishes.stream().max(Comparator.comparing(Dish::getPrice)).get();
            assertEquals(categoryDishes.get(categoryDishes.size() - 1), maxPriceDish);
        }
    }

    @Test
    public void findAllDishByCategoryOrderByPreparingtime() {
        for (Category category : categories) {
            categoryDishes = dishService.findAllAvailableDishByCategoryOrderByPreparingtime(category);

            Dish minPreparingTimeDish = categoryDishes.stream().min(Comparator.comparing(Dish::getPreparingtime)).get();
            assertEquals(categoryDishes.get(0), minPreparingTimeDish);

            Dish maxPreparingTimeDish = categoryDishes.stream().max(Comparator.comparing(Dish::getPreparingtime)).get();
            assertEquals(categoryDishes.get(categoryDishes.size() - 1), maxPreparingTimeDish);
        }
    }

    @Test
    public void findAllDishByCategoryOrderByCalories() {
        for (Category category : categories) {
            categoryDishes = dishService.findAllAvailableDishByCategoryOrderByCalories(category);

            Dish minCaloriesDish = categoryDishes.stream().min(Comparator.comparing(Dish::getCalories)).get();
            assertEquals(categoryDishes.get(0), minCaloriesDish);

            Dish maxCaloriesDish = categoryDishes.stream().max(Comparator.comparing(Dish::getCalories)).get();
            assertEquals(categoryDishes.get(categoryDishes.size() - 1), maxCaloriesDish);
        }
    }

    @Test
    public void findAllDishByCategory() {
        Assert.assertFalse(dishService.findAllAvailableDishByCategory(soupsCategory).isEmpty());

        Assert.assertNotNull(dishService.findAllAvailableDishByCategory(mealsCategory));

        Assert.assertNotNull(dishService.findAllAvailableDishByCategory(drinksCategory));

        Assert.assertTrue(dishService.findAllAvailableDishByCategory(desertsCategory).size() == 3);
    }

    @Test
    public void delete() {
        Dish lastDish = new Dish(dishes.size()+1, "Guaca", "Diced avocado, sweet white corn, black beans, jicama, bell peppers, fresh cilantro and serrano peppers. Served with housemade blue & white corn tortilla chips.",
                200, 1000, 40, new BigDecimal(3), desertsCategory, "/images/White%20corn%20guacamole.jpg", true);

        Dish createdDish = dishService.create(lastDish);

        Dish deletedDish = dishService.delete(createdDish.getId());

        Assert.assertNull(dishService.findById(deletedDish.getId()));
    }

    @Test(expected = Exception.class)
    public void tryToDelete() {
        dishService.delete(-1);
    }

    @Test
    public void findAll() {
        Assert.assertFalse(dishService.findAll().isEmpty());
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

    @Test(expected = Exception.class)
    public void tryToUpdate() throws DishNotFound {
        Dish updatedDish = dishService.findById(3L);
        updatedDish.setId(-1L);

        dishService.update(updatedDish);
    }

    @Test(expected = Exception.class)
    public void tryWrongPrice() {
        Dish dish = new Dish();

        dish.setName("Red vine");
        dish.setDescription("Gorgeous flavour");
        dish.setWeight(200);
        dish.setCalories(450);
        dish.setPreparingtime(5);
        dish.setPicture("vino_pic.jpej");
        dish.setPrice(new BigDecimal(-12));
        dish.setCategory(drinksCategory);
        dish.setAvailability(true);

        dishService.create(dish);
    }

    @Test(expected = Exception.class)
    public void tryWrongWeight() {
        Dish dish = new Dish();

        dish.setName("Red vine");
        dish.setDescription("Gorgeous flavour");
        dish.setWeight(-200);
        dish.setCalories(450);
        dish.setPreparingtime(5);
        dish.setPicture("vino_pic.jpej");
        dish.setPrice(new BigDecimal(12));
        dish.setCategory(drinksCategory);
        dish.setAvailability(true);

        dishService.create(dish);
    }

    @Test(expected = Exception.class)
    public void tryWrongPreparingTime() {
        Dish dish = new Dish();

        dish.setName("Red vine");
        dish.setDescription("Gorgeous flavour");
        dish.setWeight(200);
        dish.setCalories(450);
        dish.setPreparingtime(-5);
        dish.setPicture("vino_pic.jpej");
        dish.setPrice(new BigDecimal(12));
        dish.setCategory(drinksCategory);
        dish.setAvailability(true);

        dishService.create(dish);
    }

    @Test(expected = Exception.class)
    public void tryWrongCalories() {
        Dish dish = new Dish();

        dish.setName("Red vine");
        dish.setDescription("Gorgeous flavour");
        dish.setWeight(200);
        dish.setCalories(-450);
        dish.setPreparingtime(5);
        dish.setPicture("vino_pic.jpej");
        dish.setPrice(new BigDecimal(12));
        dish.setCategory(drinksCategory);
        dish.setAvailability(true);

       dishService.create(dish);
    }
}