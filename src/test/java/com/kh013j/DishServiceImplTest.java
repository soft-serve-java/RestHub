package com.kh013j;

import com.kh013j.model.domain.Category;
import com.kh013j.model.domain.Dish;
import com.kh013j.model.domain.Image;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.repository.DishRepository;
import com.kh013j.model.service.interfaces.DishService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
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
                (new Dish(1L, "White corn guacamol",
                        "Diced avocado, sweet white corn, black beans.",
                        200, 1000, 40,3.0, soupsCategory, new ArrayList<>(), new ArrayList<>(), true)),
                (new Dish(2L, "Camole",
                        "Diced avocado, sweet white corn, black beans.",
                        250, 1200, 10,33.0, soupsCategory, new ArrayList<>(),new ArrayList<>(), true)),
                (new Dish(3L, "Guacamole",
                        "Black beans.",
                        430, 1400, 20,56.0, soupsCategory, new ArrayList<>(),new ArrayList<>(), true)),
                (new Dish(4L, "Tiramisu",
                        "Soft.",
                        730, 1341, 26, 39.0, desertsCategory, new ArrayList<>(), new ArrayList<>(),true)),
                (new Dish(5L, "Tortinni",
                        "Delicious.",
                        330, 1909, 27, 60.0, desertsCategory, new ArrayList<>(), new ArrayList<>(), true)),
                (new Dish(6L, "Our desert",
                        "From love",
                        230, 1467, 29, 34.0, desertsCategory, new ArrayList<>(), new ArrayList<>(), true)),
                (new Dish(7L, "Gua mole",
                        "Red beans.",
                        230, 1348, 23, 39.0, mealsCategory, new ArrayList<>(), new ArrayList<>(), true)),
                (new Dish(8L, "Mole",
                        "Beans.",
                        530, 1906, 22, 6.0, mealsCategory, new ArrayList<>(), new ArrayList<>(), true)),
                (new Dish(9L, "Dishy-Issy",
                        "Different beans.",
                        730, 1409, 25, 66.0, mealsCategory, new ArrayList<>(), new ArrayList<>(), true)),
                (new Dish(10L, "Milk shake",
                        "Tasty drink",
                        521, 1317, 13, 8.0, drinksCategory, new ArrayList<>(), new ArrayList<>(), true)),
                (new Dish(11L, "Strawberry cocktail",
                        "Tasty strawberry flavour",
                        580, 1005, 14, 9.0, drinksCategory, new ArrayList<>(), new ArrayList<>(), true)),
                (new Dish(12L, "Blackberry cocktail",
                        "Tasty blackberry flavour",
                        570, 1404, 12, 11.0, drinksCategory, new ArrayList<>(), new ArrayList<>(), true))));

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
        dish.setCalories(550);
        dish.setPreparingtime(6);
        Image image = new Image();
        image.setUrl("some_pic.jpej");
        dish.setImages(new ArrayList<>(Collections.singletonList(image)));
        dish.setPrice(10.0);
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
        Image image = new Image();
        image.setUrl("mexico_pic.jpej");
        dish.setImages(new ArrayList<>(Collections.singletonList(image)));
        dish.setPrice(12.0);
        dish.setCategory(drinksCategory);
        dish.setAvailability(true);

        Dish createdDish = dishService.create(dish);

        //search a dish by id of a created dish
        Dish foundDish = dishService.findById(createdDish.getId());

        assertEquals(dish.getId(), foundDish.getId());
    }

    public void tryToFindById() {
        assertNull(dishService.findById(-1));
    }

    @Test
    public void findAllDishByCategoryOrderByPrice() {
        for (Category category : categories) {
            categoryDishes = dishService.findAllAvailableDishByCategoryOrderByPrice(category,1, "DESC").getContent();

           Dish minPriceDish = categoryDishes.stream().min(Comparator.comparing(Dish::getPrice)).get();
            assertEquals(categoryDishes.get(categoryDishes.size() - 1), minPriceDish);

            Dish maxPriceDish = categoryDishes.stream().max(Comparator.comparing(Dish::getPrice)).get();
            assertEquals(categoryDishes.get(0), maxPriceDish);
        }
    }

    @Test
    public void findAllDishByCategoryOrderByPreparingtime() {
        for (Category category : categories) {
            categoryDishes = dishService.findAllAvailableDishByCategoryOrderByPreparingtime(category, 1, "DESC").getContent();

            Dish minPreparingTimeDish = categoryDishes.stream().min(Comparator.comparing(Dish::getPreparingtime)).get();
            assertEquals(categoryDishes.get(categoryDishes.size() - 1), minPreparingTimeDish);

            Dish maxPreparingTimeDish = categoryDishes.stream().max(Comparator.comparing(Dish::getPreparingtime)).get();
            assertEquals(categoryDishes.get(0), maxPreparingTimeDish);
        }
    }

    @Test
    public void findAllDishByCategoryOrderByCalories() {
        for (Category category : categories) {
            categoryDishes = dishService.findAllAvailableDishByCategoryOrderByCalories(category,1, "DESC").getContent();

            Dish minCaloriesDish = categoryDishes.stream().min(Comparator.comparing(Dish::getCalories)).get();
            assertEquals(categoryDishes.get(categoryDishes.size() - 1), minCaloriesDish);

            Dish maxCaloriesDish = categoryDishes.stream().max(Comparator.comparing(Dish::getCalories)).get();
            assertEquals(categoryDishes.get(0), maxCaloriesDish);
        }
    }

    @Test
    public void findAllDishByCategory() {
        Assert.assertFalse(dishService.findAllAvailableDishByCategory(soupsCategory, 1).getContent().isEmpty());

        Assert.assertNotNull(dishService.findAllAvailableDishByCategory(mealsCategory, 1));

        Assert.assertNotNull(dishService.findAllAvailableDishByCategory(drinksCategory, 1));
        }

    @Test
    public void delete() {
        Dish lastDish = new Dish(dishes.size()+1, "Guaca", "Diced avocado, sweet white corn, black beans, jicama, bell peppers, fresh cilantro and serrano peppers. Served with housemade blue & white corn tortilla chips.",
                200, 1000, 40,3.0, desertsCategory, null, null, true);

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
        dish.setCalories(456);
        dish.setPreparingtime(7);
        Image image = new Image();
        image.setUrl("vino_pic.jpej");
        dish.setImages(new ArrayList<>(Collections.singletonList(image)));
        dish.setPrice(-12.0);
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
        dish.setCalories(453);
        dish.setPreparingtime(8);
        Image image = new Image();
        image.setUrl("vino_pic.jpej");
        dish.setImages(new ArrayList<>(Collections.singletonList(image)));
        dish.setPrice(12.0);
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
        dish.setCalories(452);
        dish.setPreparingtime(-5);
        Image image = new Image();
        image.setUrl("vino_pic.jpej");
        dish.setImages(new ArrayList<>(Collections.singletonList(image)));
        dish.setPrice(12.0);
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
        dish.setPreparingtime(9);
        Image image = new Image();
        image.setUrl("vino_pic.jpej");
        dish.setImages(new ArrayList<>(Collections.singletonList(image)));
        dish.setPrice(12.0);
        dish.setCategory(drinksCategory);
        dish.setAvailability(true);

       dishService.create(dish);
    }
}