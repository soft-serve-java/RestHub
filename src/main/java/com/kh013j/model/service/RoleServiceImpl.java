package com.kh013j.model.service;

import com.kh013j.model.domain.Role;
import com.kh013j.model.repository.RoleRepository;
import com.kh013j.model.service.interfaces.RoleService;

import javax.annotation.Resource;
import java.util.List;

public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleRepository roleRepository;

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    /*@Override
    public void delete(long id){
        roleRepository.delete(id);
    }*/

    @Override
    public Role delete(long id){
        Role deletedRole = roleRepository.findOne(id);
        roleRepository.delete(deletedRole);
        return deletedRole;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role update(Role role){
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public Role findById(long id) {
        return roleRepository.findOne(id);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
