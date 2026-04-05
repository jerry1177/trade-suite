package com.tradesuite.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    // This controller can be used for any home page related endpoints in the future
    @GetMapping("/")
    public String getHome() {
        return new String("Welcome to the Trade Suite API!");
    }
    
}