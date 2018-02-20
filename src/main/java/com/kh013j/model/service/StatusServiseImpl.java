package com.kh013j.model.service;

import com.kh013j.model.domain.Status;
import com.kh013j.model.repository.StatusRepositiry;
import com.kh013j.model.service.interfaces.StatusService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class StatusServiseImpl implements StatusService {
    @Resource
    private StatusRepositiry statusRepositiry;
    @Override
    public Status create() {
        return statusRepositiry.findFirstByName(Status.PREPARING);
    }

    @Override
    public Status nextStatus(Status status) {
        switch (status.getName()){
            case Status.PREPARING:
                return statusRepositiry.findFirstByName(Status.COOKING);
            case Status.COOKING:
                return statusRepositiry.findFirstByName(Status.DELIVERY);
                default:
                    throw new UnsupportedOperationException();
        }
    }

    @Override
    public List<Status> cookersStatuses() {
        List<Status> statuses = new ArrayList<>();
        statuses.add(statusRepositiry.findFirstByName(Status.COOKING));
        statuses.add(statusRepositiry.findFirstByName(Status.PREPARING));
        return statuses;
    }

    @Override
    public List<Status> waiterStatuses() {
        List<Status> statuses = new ArrayList<>();
        statuses.add(statusRepositiry.findFirstByName(Status.DELIVERY));
        return statuses;
    }
}
