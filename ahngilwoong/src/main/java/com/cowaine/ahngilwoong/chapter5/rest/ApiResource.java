package com.cowaine.ahngilwoong.chapter5.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiResource {

    @GetMapping(path = {"/", "/home"})
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body("Hello World");
    }

}
