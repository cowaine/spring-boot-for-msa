package com.cowaine.corock.chapter06.controller.resolver;

import com.cowaine.corock.chapter06.controller.ClientInfo;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class ClientInfoArgumentResolver implements HandlerMethodArgumentResolver {

    public static final String HEADER_CHANNEL = "X-SPRINGTOUR-CHANNEL";
    public static final String HEADER_CLIENT_IP = "X-FORWARDED-FOR";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if (!ClientInfo.class.equals(parameter.getParameterType())) {
            return false;
        }
        return true;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String channel = webRequest.getHeader(HEADER_CHANNEL);
        String clientAddress = webRequest.getHeader(HEADER_CLIENT_IP);

        return new ClientInfo(channel, clientAddress);
    }

}
