package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.Status;

import java.util.List;

public interface StatusService {
    Status create();
    Status nextStatus(Status status);
    List<Status> cookStatuses();
    List<Status> waiterStatuses();
    List<Status> findAll();
}
