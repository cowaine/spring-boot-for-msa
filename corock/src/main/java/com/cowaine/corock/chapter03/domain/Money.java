package com.cowaine.corock.chapter03.domain;

import lombok.Getter;

import java.io.Serializable;
import java.util.Currency;
import java.util.Objects;

@Getter
public final class Money implements Serializable {

    private final Long amount;
    private final Currency currency;

    public Money(Long amount, Currency currency) {
        if (Objects.isNull(amount) || amount < 0) {
            throw new IllegalArgumentException("invalid amount: " + amount);
        }
        if (Objects.isNull(currency)) {
            throw new IllegalArgumentException("invalid currency");
        }

        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // Money money = Money.class.cast(obj);
        Money money = (Money) obj;

        return Objects.equals(amount, money.amount) && Objects.equals(currency, money.currency);
    }

}
