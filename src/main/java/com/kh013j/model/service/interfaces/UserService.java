package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.User;

import java.util.List;

public interface UserService {
    User create(User order);

    /*    void delete(long id);*/
    User delete(long id);

    List<User> findAll();

    User update(User order);

    User findById(long id);

    User findByEmail(String email);

    User findByConfirmationtoken(String token);
}
