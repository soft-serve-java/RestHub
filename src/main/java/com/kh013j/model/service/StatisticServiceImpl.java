package com.kh013j.model.service;

import com.kh013j.model.domain.Dish;
import com.kh013j.model.repository.DishRepository;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticServiceImpl {
    @Resource
    private DishRepository dishRepository;

    public List<Dish> sortDishesByPopularity(){
        return null;
    }
    public static List<Integer> showAsPesrents(List<Object[]> list, int indexOfpesrantable){
        int oneHundred = list.stream().mapToInt(ob->(int)ob[indexOfpesrantable]).sum();
        return list.stream().map(objects -> (int)objects[indexOfpesrantable]*100/oneHundred).collect(Collectors.toList());
    }
}
