package com.example.vuespringbootinicis.pay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/pay")
@RestController
public class PayController {

    @GetMapping("/test")
    public String getData() {
        return "hihihi";
    }
}
