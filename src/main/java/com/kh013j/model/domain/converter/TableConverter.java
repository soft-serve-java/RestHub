package com.kh013j.model.domain.converter;

import com.kh013j.model.domain.Tables;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TableConverter implements AttributeConverter<Tables, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Tables tables) {
        return tables.getCurrentTable();
    }

    @Override
    public Tables convertToEntityAttribute(Integer tablenumber) {
        return new Tables(tablenumber);
    }
}
