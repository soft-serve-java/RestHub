package com.kh013j.model.service;

import com.kh013j.model.domain.Status;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.repository.StatusRepositiry;
import com.kh013j.model.service.interfaces.StatusService;

import javax.annotation.Resource;
import java.util.List;

public class StatusServiseImpl implements StatusService {
    @Resource
    StatusRepositiry statusRepositiry;

    @Override
    public Status create(Status status) {
        return statusRepositiry.save(status);
    }

    @Override
    public void delete(long id){
        statusRepositiry.delete(id);
    }

    @Override
    public List findAll() {
            return statusRepositiry.findAll();
        }

    @Override
    public Status update(Status status){
        return statusRepositiry.saveAndFlush(status);
    }

    @Override
    public Status findById(long id) {
        return statusRepositiry.findOne(id);
    }

    @Override
    public Status findByName(String name) {
        return statusRepositiry.findFirstByName(name);
    }
}
