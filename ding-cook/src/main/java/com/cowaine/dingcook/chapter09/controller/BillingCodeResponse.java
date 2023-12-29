package com.cowaine.dingcook.chapter09.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BillingCodeResponse {

    private String billingCode;

    public static BillingCodeResponse of(String billingCode) {
        BillingCodeResponse response = new BillingCodeResponse();
        response.billingCode = billingCode;
        return response;
    }
}
