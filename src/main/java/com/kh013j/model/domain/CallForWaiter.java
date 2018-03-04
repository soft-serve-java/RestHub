package com.kh013j.model.domain;


import com.kh013j.model.domain.converter.TableConverter;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "callforwaiter", schema = "rh")
@RequiredArgsConstructor
public class CallForWaiter {
    @Id
    long id;

    @NonNull
    @Convert(converter = TableConverter.class)
    Tables table;

    @ManyToOne
    @JoinColumn(name = "waiter_id")
    User waiter;

    @NonNull
    Timestamp timeCreate;

    Timestamp timeClose;
    @NonNull
    @Transient
    String sessoinId;
}
