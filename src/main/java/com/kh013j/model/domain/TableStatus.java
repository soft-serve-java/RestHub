package com.kh013j.model.domain;

import java.io.Serializable;

public enum TableStatus implements Serializable {
    HAS_NULL_WAITER,
    IS_OF_CURRENT_WAITER,
    IS_ON_DELIVERY,
    FREE;

    public String getStatus() {
        return this.name();
    }
}