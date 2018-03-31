package com.kh013j.model.domain.converter;

import javax.persistence.AttributeConverter;
import java.math.BigDecimal;

public class PriceConverter implements AttributeConverter<Double, BigDecimal> {

    @Override
    public BigDecimal convertToDatabaseColumn(Double aDouble) {
        return new BigDecimal(aDouble);
    }

    @Override
    public Double convertToEntityAttribute(BigDecimal bigDecimal) {
        return bigDecimal.doubleValue();
    }
}
