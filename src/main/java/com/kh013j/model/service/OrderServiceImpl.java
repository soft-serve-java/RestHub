package com.kh013j.model.service;

import com.kh013j.model.domain.*;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.repository.OrderRepository;
import com.kh013j.model.service.interfaces.OrderService;
import com.kh013j.model.service.interfaces.OrderedDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static com.kh013j.model.domain.TableStatus.*;
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderRepository orderRepository;
    @Autowired
    private CallForWaiterService callForWaiterService;

    @Autowired
    private OrderedDishService orderedDishService;

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order delete(long id) throws DishNotFound {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order update(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    @Override
    public Order findById(long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Order findByTable(int table) {
        return orderRepository.findFirstByTablenumberAndClosedFalse(table);
    }

    @Override
    public Order createOrderFromMap(Map<Dish, Integer> orderMap, int tablenumber) {
        Order order = new Order();
        order.setTime(new Timestamp(new Date().getTime()));
        order.setTablenumber(tablenumber);
        order.setOrderedFood(orderedDishService.createOrderedDishesFromMap(orderMap, order));
        return order;
    }

    @Override
    public void onSubmitOrder(int tablenumber, Map<Dish, Integer> orderMap, User user) {
        Order order = findByTable(tablenumber);
        if (order != null) {
            order.getOrderedFood().addAll(orderedDishService.createOrderedDishesFromMap(orderMap, order));
        } else {
            order = createOrderFromMap(orderMap, tablenumber);
        }
        order.setUser(user);
        orderRepository.saveAndFlush(order);
    }

    private List<Tables> findNullWaiterTables(List<Order> orders) {
        return orders.stream().filter(order -> order.getWaiter()==null)
                .map(order -> new Tables(order.getTablenumber(),HAS_NULL_WAITER))
                .collect(Collectors.toList());
    }

    private List<Tables> findTablesInDeliveryStatus(List<Order> orders) {
        return orders.stream()
                .filter(Order::hasFoodForDeliver)
                .map(order -> new Tables(order.getTablenumber(),IS_ON_DELIVERY))
               .collect(Collectors.toList());
    }

    private List<Tables> findNotThisWaiterTables(List<Order> orders) {
        return orders.stream().filter(order -> order.getWaiter()!=null)
                .map(order -> new Tables(order.getTablenumber(),HAS_WAITER, order.getWaiter()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Tables> findTableInfoForWaiter(){
        List<Order> orders = orderRepository.findAllByClosedFalse();
        List<Tables> tablesForWaiter = new ArrayList<>();
        tablesForWaiter.addAll(findNullWaiterTables(orders));
        tablesForWaiter.addAll(findTablesInDeliveryStatus(orders));
        tablesForWaiter.addAll(findNotThisWaiterTables(orders));
        tablesForWaiter.addAll(callForWaiterService.findAll().stream()
                .map(callForWaiter -> new Tables(callForWaiter.getTable()
                        .getCurrentTable(),CALLING_WAITER))
                .collect(Collectors.toList()));
        return tablesForWaiter;
    }

    @Override
    public void setWaiter(int table, User waiter) {
        Order order = orderRepository.findFirstByTablenumberAndClosedFalse(table);
        order.setWaiter(waiter);
        update(order);
    }

    @Override
    public Order closeOrder(int table) {
        Order order = orderRepository.findFirstByTablenumberAndClosedFalse(table);
        order.setClosed(true);
        return update(order);
    }
}

