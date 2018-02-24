package com.kh013j.model.domain;


import com.kh013j.model.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Data
//TODO: in DB
@RequiredArgsConstructor
public class CallForWaiter {
    @NonNull
    Tables table;
    User waiter;
    @NonNull
    Timestamp timeCreate;
    Timestamp timeClose;
}
