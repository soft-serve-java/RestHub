package com.kh013j.restcontrollers;

import com.kh013j.model.domain.Category;
import com.kh013j.model.domain.Dish;
import com.kh013j.model.domain.Tag;
import com.kh013j.model.service.interfaces.CategoryService;
import com.kh013j.model.service.interfaces.DishService;
import com.kh013j.model.service.interfaces.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/dish")
public class DishControllerRest {

    private DishService dishService;

    private CategoryService categoryService;

    private TagService tagService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DishControllerRest.class);

    @Autowired
    public DishControllerRest(DishService dishService, CategoryService categoryService, TagService tagService) {
        this.dishService = dishService;
        this.categoryService = categoryService;
        this.tagService = tagService;
    }

    @GetMapping("/all")
    public List<Dish> getAllDishes(){
        return dishService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable long id){
        Dish dish = dishService.findById(id);

        if (dish == null) {
            LOGGER.error("Dish with id: {0} wasn't found", id);
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dish);
    }

    @GetMapping("/by{category}")
    public ResponseEntity<List<Dish>> getDishesByCategory(@PathVariable("category") String categoryName,
                                                          @RequestParam(value = "page", required = false) Integer pageNumber){
        if(pageNumber == null || pageNumber < 1) {
            pageNumber = 1;
        }

        Category category = categoryService.findCategoryByName(categoryName);
        if (category == null){
            return ResponseEntity.notFound().build();
        }
        Page<Dish> dishPage = dishService.findAllAvailableDishByCategory(category, pageNumber);
        return ResponseEntity.ok().headers(getHeaders(dishPage.getTotalPages())).body(dishPage.getContent());
    }

    @GetMapping("/search/{tag}")
    public ResponseEntity<List<Dish>> getDishesByTag(@PathVariable("tag") String tagName,
                                                    @RequestParam(value = "page", required = false) Integer pageNumber){
        if(pageNumber == null || pageNumber < 1) {
            pageNumber = 1;
        }
        Page<Dish> dishPage = dishService.findAllAvailableDishByTagName(tagName, pageNumber);
        return ResponseEntity.ok().headers(getHeaders(dishPage.getTotalPages())).body(dishPage.getContent());
    }

    private HttpHeaders getHeaders(int lastPage){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("access-control-expose-headers", "last");
        httpHeaders.add("last", String.valueOf(lastPage));
        return httpHeaders;
    }

    @GetMapping("/{id}/populars")
    public List<Dish> getPopularsById(@PathVariable long id){
        return dishService.findPopular(id);
    }

    @GetMapping("/")
    public List<Dish> getDishesByName(@RequestParam("search") String searchText){
        return dishService.findByAvailableAndNameContaining(searchText);
    }
}
