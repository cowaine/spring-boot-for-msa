package com.cowaine.coalong.chapter03.service;

import com.cowaine.coalong.chapter03.domain.OrderProduct;
import com.cowaine.coalong.chapter03.domain.format.Formatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.StringJoiner;

@Service
public class OrderPrinter implements Printer<OrderProduct> {

    // 1. Field injection is not recommended
    @Autowired
    @Qualifier("localDateFormatter")
    private Formatter<LocalDateTime> formatter2;
    private Formatter<LocalDateTime> formatter3;
    private Formatter<LocalDateTime> formatter;

    // 3. Constructor Injection
    // @Autowired /* 생성자 주입 방법에서는  @Autowired 생략 가능 관례 (public 생성자 1개일 경우에만)
    public OrderPrinter(@Qualifier("localDateFormatter") Formatter<LocalDateTime> formatter) {
        this.formatter = formatter;
    }

    // 2. Setter Method Injection
    @Autowired
    public void setFormatter(@Qualifier("localDateFormatter") Formatter<LocalDateTime> formatter3) {
        this.formatter3 = formatter3;
    }

    @Override
    public void print(OutputStream os, OrderProduct orderProduct) throws IOException {
        StringJoiner stringJoiner = new StringJoiner("+");
        stringJoiner.add(orderProduct.getBuyerName());
        stringJoiner.add(orderProduct.getOrderAmount().toPlainString());
        stringJoiner.add(formatter.of((orderProduct.getOrderAt())));
    }
}
