package com.kh013j;

import com.kh013j.model.domain.Order;
import com.kh013j.model.domain.OrderedDish;
import com.kh013j.model.domain.Role;
import com.kh013j.model.domain.User;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.repository.OrderRepository;
import com.kh013j.model.service.interfaces.OrderService;
import com.kh013j.model.service.interfaces.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDishRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    private Order order = new Order();

   @Test
    public void isOrderAdded() {
       User user1 = new User();
       Role role = new Role(1, "Admin");
       HashSet<Role> roles = new HashSet<>();
       roles.add(role);

       User user = userService.findById(1);

       Timestamp time = new Timestamp(22L);

       order = new Order(1, time, user,   1, false, new ArrayList<OrderedDish>(), null);
       orderService.create(order);
        Assert.notNull(orderRepository.save(order), "Dish added");
    }

    /*@Test
    public void isOrderDeleted() throws DishNotFound {
        Assert.notNull(orderService.delete(1L), "Dish deleted");
    }*/

    @Test
    public void isOrdersEqual() {
        User user1 = new User();
        Role role = new Role(1, "Admin");
        HashSet<Role> roles = new HashSet<>();
        roles.add(role);
        User user =  userService.findById(1);
        Timestamp time = new Timestamp(22L);
        order = new Order(1, time, user,   1, false, new ArrayList<OrderedDish>(), null);
        orderService.create(order);
        Assert.isTrue(order.equals(orderRepository.findOne(1L)));
    }

}
