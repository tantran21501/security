package com.example.securitybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalancerController {
    @GetMapping("/myBalancer")
    public String getBalancer(){
        return "balancer details";
    }
}
