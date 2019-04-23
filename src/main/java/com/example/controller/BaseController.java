package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class BaseController {

    @GetMapping("/test")
    public Object test(){
        return "obj";
    }
}
