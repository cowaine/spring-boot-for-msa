package com.cowaine.youngjujang.ch6.domain.controller.resolver;

import com.cowaine.youngjujang.ch6.domain.controller.ClientInfo;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class ClientInfoArgumentResolver implements HandlerMethodArgumentResolver {
     
     private static final String HEADER_CHANNEL = "X-SPRINGTOUR-CHANNEL";
     private static final String HEADER_CLIENT_IP = "X-FORWARDED-FOR";
     
     @Override
     public boolean supportsParameter(MethodParameter parameter) {
          return ClientInfo.class.equals(parameter.getParameterType());
     }
     
     @Override
     public Object resolveArgument(MethodParameter parameter,
                                   ModelAndViewContainer mavContainer,
                                   NativeWebRequest webRequest,
                                   WebDataBinderFactory binderFactory) throws Exception {
          String channel = webRequest.getHeader(HEADER_CHANNEL);
          String clientAddress = webRequest.getHeader(HEADER_CLIENT_IP);
          return new ClientInfo(channel, clientAddress);
     }
}
