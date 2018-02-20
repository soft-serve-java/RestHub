package com.kh013j.model.service.comparator;

import com.kh013j.model.domain.Dish;

import java.util.Comparator;

public class CaloriesComparator implements Comparator<Dish>{
    @Override
    public int compare(Dish d1, Dish d2) {
        if (d1.getCalories() < d2.getCalories()) {
            return -1;
        } else if (d1.getCalories() > d2.getCalories()) {
            return 1;
        } else return 0;
    }
}
