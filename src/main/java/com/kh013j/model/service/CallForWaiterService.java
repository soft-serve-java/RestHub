package com.kh013j.model.service;

import com.kh013j.model.domain.CallForWaiter;
import com.kh013j.model.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Component
public class CallForWaiterService {
    List<CallForWaiter> callForWaiters = new ArrayList<>();
    List<CallForWaiter> closed = new ArrayList<>();

    public CallForWaiter create(CallForWaiter callForWaiter){
        callForWaiters.add(callForWaiter);
        return callForWaiter;
    }

    public List<CallForWaiter> findAll() {
        return callForWaiters;
    }

    public void mackAsClosed(int tablenumber, User waiter){
        CallForWaiter call = findByTableNumber(tablenumber);
        callForWaiters.remove(call);
        call.setWaiter(waiter);
        call.setTimeClose(new Timestamp(System.currentTimeMillis()));
        closed.add(call);
        if(closed.size() == 10){
            //flush it in db with future
            closed.clear();
        }
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
