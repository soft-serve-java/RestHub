package com.kh013j.model.service;

import com.kh013j.model.domain.*;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.repository.OrderRepository;
import com.kh013j.model.service.interfaces.OrderService;
import com.kh013j.model.service.interfaces.OrderedDishService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static com.kh013j.model.domain.TableStatus.*;
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderRepository orderRepository;

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
    public List findAll() {
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
    public void onSubmitOrder(int tablenumber, Map<Dish, Integer> orderMap) {
        Order order = findByTable(tablenumber);
        if (order != null) {
            order.getOrderedFood().addAll(orderedDishService.createOrderedDishesFromMap(orderMap, order));
        } else {
            order = createOrderFromMap(orderMap, tablenumber);
        }
        orderRepository.saveAndFlush(order);
    }

    private List<Tables> findNullWaiterTables() {
        return orderRepository.findAllByWaiterNullAndClosedFalse().stream()
                .map(order -> new Tables(order.getTablenumber(),HAS_NULL_WAITER))
                .collect(Collectors.toList());
    }

    private List<Tables> findTablesByWaiter(User waiter) {
        return orderRepository.findAllByWaiterAndClosedFalse(waiter).stream()
                .map(order -> new Tables(order.getTablenumber(),IS_OF_CURRENT_WAITER))
                .collect(Collectors.toList());
    }

    private List<Tables> findTablesInDeliveryStatus() {
        return orderRepository.findAll().stream()
                .filter(Order::hasFoodForDeliver)
                .map(order -> new Tables(order.getTablenumber(),IS_ON_DELIVERY))
               .collect(Collectors.toList());
    }
    private List<Tables> findNotThisWaiterTables(User waiter) {
        return orderRepository.findAllByWaiterNotAndClosedFalse(waiter).stream()
                .map(order -> new Tables(order.getTablenumber(),HAS_WAITER))
                .collect(Collectors.toList());
    }

        @Override
    public List<Tables> findTableInfoForWaiter(User waiter){
        //TODO:Try to call DB only one time;
        List<Tables> tablesForWaiter = callForWaiterService.findAll().stream()
                .map(callForWaiter -> new Tables(callForWaiter.getTable().getCurrentTable(),CALLING_WAITER))
                .collect(Collectors.toList());
        tablesForWaiter.addAll(findTablesByWaiter(waiter));
        tablesForWaiter.addAll(findNotThisWaiterTables(waiter));
        tablesForWaiter.addAll(findTablesInDeliveryStatus());
        tablesForWaiter.addAll(findNullWaiterTables());
        return tablesForWaiter;
    }
}

