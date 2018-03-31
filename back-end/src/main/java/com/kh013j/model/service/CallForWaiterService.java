package com.kh013j.model.service;

import com.kh013j.model.domain.CallForWaiter;
import com.kh013j.model.domain.User;
import com.kh013j.model.repository.CallForWaiterRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@Component
public class CallForWaiterService {
    @Resource
    private CallForWaiterRepository callForWaiterRepository;

    private  List<CallForWaiter> callForWaiters = new ArrayList<>();

    private List<CallForWaiter> closed = new ArrayList<>();

    private static final int BUFFER = 1;

    public CallForWaiter create(CallForWaiter callForWaiter){
        callForWaiters.add(callForWaiter);
        return callForWaiter;
    }

    public List<CallForWaiter> findAll() {
        return callForWaiters;
    }

    public CallForWaiter mackAsClosed(int tablenumber, User waiter){
        CallForWaiter call = findByTableNumber(tablenumber);
        callForWaiters.remove(call);
        call.setWaiter(waiter);
        call.setTimeClose(new Timestamp(System.currentTimeMillis()));
        closed.add(call);
        if(closed.size() == BUFFER){
            CompletableFuture.runAsync(()-> callForWaiterRepository.save(callForWaiters));
            closed.clear();
        }
        return call;
    }
    public boolean add(CallForWaiter callForWaiter){
        if (!callForWaiters.contains(callForWaiter)){
            return callForWaiters.add(callForWaiter);
        }
        return false;
    }

    private CallForWaiter findByTableNumber(int tablenumber) {
        return callForWaiters.stream().
                filter(callForWaiter -> callForWaiter.getTable().getCurrentTable()==tablenumber)
                .findFirst().get();
    }
}