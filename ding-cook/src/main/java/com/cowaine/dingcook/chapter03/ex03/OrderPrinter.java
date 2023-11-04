//package com.cowaine.dingcook.domain.printer;
//
//import com.cowaine.dingcook.domain.formatter.Formatter;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.Locale;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.format.Printer;
//
//public class OrderPrinter implements Printer<ProductOrder> {
//
//    // 필드 주입
//    @Autowired
//    @Qualifier("localDateTimeFormatter")
//    private Formatter formatter01;
//
//    private Formatter formatter02;
//
//    //Setter 주입
//    public void setFormatter02(@Qualifier("localDateTimeFormatter") Formatter formatter02) {
//        this.formatter02 = formatter02;
//    }
//
//    private Formatter formatter03;
//
//    //생성자 주입
//    public OrderPrinter(Formatter formatter03) {
//        this.formatter03 = formatter03;
//    }
//
//    @Override
//    public String print(OutputStream os, ProductOrder productOrder) throws IOException {
//        String orderAt = formatter01.of(productOrder.getOrderAt());
//        os.write(orderAt.getBytes());
//    }
//}
