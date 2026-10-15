package com.Switchly.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v7")
public class HelloController {
    @GetMapping("/boy")
    public String Hello(){
        return "Hello";
    }
}
