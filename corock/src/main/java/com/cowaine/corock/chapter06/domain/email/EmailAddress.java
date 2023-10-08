package com.cowaine.corock.chapter06.domain.email;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class EmailAddress {

    private static final String AT = "@";

    private String name;
    private String localPart;
    private String domainPart;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (Objects.nonNull(name)) {
            sb.append(name).append(" ");
        }

        return sb.append("<").append(localPart).append(AT).append(domainPart).append(">").toString();
    }

}
