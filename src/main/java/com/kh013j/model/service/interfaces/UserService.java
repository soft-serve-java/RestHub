package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.User;
import org.springframework.data.domain.Page;

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

    Integer deleteNotEnabledUsers();

    Page<User> findAllUser(Integer pageNumber);

    Page<User> findAllEnabledUser(Integer pageNumber, boolean enabled);
}
