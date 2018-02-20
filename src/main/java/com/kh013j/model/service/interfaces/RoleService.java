package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.Role;
import com.kh013j.model.exception.DishNotFound;

import java.util.List;

public interface RoleService {
    Role create(Role role);

    void delete(long id);

    List findAll();

    Role update(Role role);

    Role findById(long id);

    Role findByName(String name);
}
