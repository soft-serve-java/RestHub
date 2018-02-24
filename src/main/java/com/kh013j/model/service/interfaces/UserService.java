package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.User;
import com.kh013j.model.exception.DishNotFound;

import java.util.List;

public interface UserService {
    User create(User order);

    void delete(long id) throws DishNotFound;

    List findAll();

    User update(User order) throws DishNotFound;

    User findById(long id);

    User findByEmail(String email);

    User findByConfirmationtoken(String token);
}
