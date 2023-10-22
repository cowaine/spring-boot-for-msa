package com.cowaine.crupy.part5.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component("part5HotelController")
public class HotelController {

    @GetMapping("/hotels")
    public void getHotels(){
        System.out.println("getHotels");
    }

    @GetMapping(path = "/hotels", params = "isOpen")
    public void getHotelsByOpen(){
        System.out.println("getHotelsByOpen");
    }
}
