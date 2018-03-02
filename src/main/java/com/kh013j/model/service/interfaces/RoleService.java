package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.Role;

import java.util.List;

public interface RoleService {
    Role create(Role role);

    /*void delete(long id);*/
    Role delete(long id);

    List<Role> findAll();

    Role update(Role role);

    Role findById(long id);

    Role findByName(String name);
}
