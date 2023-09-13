package com.cowaine.crupy.part6.globals.filter;


import javax.servlet.*;
import java.io.IOException;

public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("선처리 작업");
        chain.doFilter(request, response);
        System.out.println("후처리 작업");
    }
}
