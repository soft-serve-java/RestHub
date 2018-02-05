package com.kh013j;

import com.kh013j.model.domain.Category;
import com.kh013j.model.repository.CategoryRepository;
import com.kh013j.model.repository.DishRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CaffinnoApplicationTests {
    @Autowired
		CategoryRepository categoryRepository;
    @Autowired
		DishRepository dishRepository;

	@Test
	public void contextLoads() {
	}
	@Test
	public void newCategory(){
		categoryRepository.save(new Category(1, "salad"));
		Assert.assertEquals(new Category(1, "salad"),  categoryRepository.findOne(1L));
	}
	@Test
	public void WATT(){
		Assert.assertEquals(4,  categoryRepository.findAll().size());
	}
	@Test
	public void insertedDishInLiqiubase(){
Assert.assertEquals(1, dishRepository.findAll().size());
	}
}