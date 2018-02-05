package com.kh013j.model.repository;
import com.kh013j.model.domain.Category;
import com.kh013j.model.domain.Dish;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  DishRepository extends JpaRepository<Dish, Long> {
  public List<Dish> findAllByCategory(Category category);
}