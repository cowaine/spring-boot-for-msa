package com.cowaine.corock.chapter03.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;

@Service
public class OrderPrinter implements Printer<OrderProduct> {

    // 1. Field Injection (Field injection is not recommended)
    // @Autowired
    // @Qualifier("localDateTimeFormatter")
    // private Formatter<LocalDateTime> formatter01;

    // private Formatter<LocalDateTime> formatter02;

    // 2. Setter Method Injection
    // @Autowired
    // public void setFormatter02(@Qualifier("localDateTimeFormatter") Formatter<LocalDateTime> formatter) {
    //     this.formatter02 = formatter;
    // }

    private Formatter<LocalDateTime> formatter;

    // 3. Constructor Injection
    public OrderPrinter(@Qualifier("localDateTimeFormatter") Formatter<LocalDateTime> formatter) {
        this.formatter = formatter;
    }

    @Override
    public void print(OutputStream os, OrderProduct orderProduct) throws IOException {
        String orderAt = formatter.of(orderProduct.getOrderAt());
        os.write(orderAt.getBytes());
    }

}
