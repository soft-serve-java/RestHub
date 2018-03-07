package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.Status;
import com.kh013j.model.exception.DishNotFound;

import java.util.List;

public interface StatusService {
    Status create();
    Status nextStatus(Status status);
    List<Status> cookersStatuses();
    List<Status> waiterStatuses();
}
