package com.kh013j.model.service;

import com.kh013j.model.domain.Status;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.repository.StatusRepositiry;
import com.kh013j.model.service.interfaces.StatusService;

import javax.annotation.Resource;
import java.util.List;

public class StatusServiseImpl implements StatusService{
    @Resource
    StatusRepositiry statusRepositiry;
    @Override
    public Status create(Status status) {
        return null;
    }

    @Override
    public void delete(long id){

    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Status update(Status status){
        return null;
    }

    @Override
    public Status findById(long id) {
        return null;
    }

    @Override
    public Status findByName(String name) {
        return statusRepositiry.findFirstByName(name);
    }
}
