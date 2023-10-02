package com.cowaine.coalong.chapter03.domain;

import lombok.Getter;

import java.io.Serializable;
import java.util.Currency;
import java.util.Objects;

@Getter
public final class Money implements Serializable {
    private final Long value;
    private final Currency currency;

    public Money(Long value, Currency currency) {
        if (Objects.isNull(value) || value < 0) {
            throw new IllegalArgumentException("invalid value: " + value);
        }
        if (Objects.isNull(currency)) {
            throw new IllegalArgumentException("invalid currency");
        }

        this.value = value;
        this.currency = currency;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return false;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

//        Money money = Money.class.cast(obj);
        Money money = (Money) obj;

        return Objects.equals(value, money.value) && Objects.equals(currency, money.currency);
    }


}
