package com.vti.rw41.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloWorldController {
    @GetMapping("/")
    public String hello( String name){
        return "Xin chào! " + name;
    }
}
