package com.kh013j.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Tables {
    static int quantityOfTables = 5;
    @NonNull
    int currentTable;
}
