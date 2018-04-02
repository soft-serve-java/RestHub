package com.kh013j.model.service;

import com.kh013j.model.domain.Category;
import com.kh013j.model.domain.Review;
import com.kh013j.model.domain.Dish;
import com.kh013j.model.domain.Tag;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.repository.ReviewRepository;
import com.kh013j.model.repository.DishRepository;
import com.kh013j.model.repository.TagRepository;
import com.kh013j.model.service.interfaces.DishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

public class DishServiceImpl implements DishService {
    @Resource
    private DishRepository dishRepository;

    @Resource
    private ReviewRepository reviewRepository;

    @Resource
    private TagRepository tagRepository;

    Logger logger = LoggerFactory.getLogger(DishServiceImpl.class);

    /**
     * Number of dishes in one page
     */
    private static final int PAGE_SIZE = 16;

    @Override
    @Transactional
    public Dish create(Dish dish) {
        List<Tag> tags = tagRepository.findAll();

        List<Tag> attachedTags = new LinkedList<>();
        for (Tag tag: dish.getTags()){
                attachedTags.add(tags.stream().
                        filter(tag1 -> tag1.getTitle().equalsIgnoreCase(tag.getTitle()))
                        .findFirst()
                        .orElse(new Tag(tag.getTitle())));
        }

        dish.setTags(attachedTags);
        return dishRepository.save(dish);
    }

    @Override
    @Transactional
    public Dish findById(long id) {
        return dishRepository.findOne(id);
    }

    @Override
    public Page<Dish>  findAllAvailableDishByCategoryOrderByPrice(Category category, Integer pageNumber, String sortingDirection) {
        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE, getSortingDirection(sortingDirection), "price");
        return dishRepository.findAllByCategoryAndAvailabilityTrue(category, request);
    }

    @Override
    public Page<Dish>  findAllAvailableDishByCategoryOrderByPreparingtime(Category category, Integer pageNumber, String sortingDirection) {
        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE, getSortingDirection(sortingDirection), "preparingtime");
        return dishRepository.findAllByCategoryAndAvailabilityTrue(category, request);
    }

    @Override
    public Page<Dish>  findAllAvailableDishByCategoryOrderByCalories(Category category, Integer pageNumber, String sortingDirection) {
        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE, getSortingDirection(sortingDirection), "calories");
        return dishRepository.findAllByCategoryAndAvailabilityTrue(category, request);
    }

    @Override
    public Page<Dish> findAllAvailableDishByCategory(Category category, Integer pageNumber) {
        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE);
        return dishRepository.findAllByCategoryAndAvailabilityTrue(category, request);
    }

    @Override
    public List<Dish> findByAvailableAndNameContaining(String name) {
        return dishRepository.findByNameContainingIgnoreCaseAndAvailabilityTrue(name);
    }

    @Override
    @Transactional(rollbackFor = DishNotFound.class)
    public Dish delete(long id)  {
        Dish deletedDish = dishRepository.findOne(id);
        dishRepository.delete(deletedDish);
        return deletedDish;
    }

    @Override
    @Transactional
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public List<Dish>  findAllAvailable() {
        return dishRepository.findAllByAvailability(true);
    }

    @Override
    public List<Dish> findPopular(long id) {
        return dishRepository.findDishByPopularCustomQuery(id);
    }


    @Override
    public Dish update(Dish dish) throws DishNotFound {
        return dishRepository.saveAndFlush(dish);
    }

    @Override
    public Dish tweakAvailability(long id) {
        Dish dish = dishRepository.findOne(id);
        if (dish == null) {
            return null;
        }
        dish.setAvailability(!dish.isAvailability());
        dishRepository.saveAndFlush(dish);
        return dish;
    }

    @Override
    public List<Review> getReviews(Dish dish) {
        return reviewRepository.findAllByDishAndApprovedTrue(dish);
    }

    private Sort.Direction getSortingDirection(String direction){
        if (direction.equalsIgnoreCase("DESC")){
            return Sort.Direction.DESC;
        } else {
            return Sort.Direction.ASC;
        }
    }
}
