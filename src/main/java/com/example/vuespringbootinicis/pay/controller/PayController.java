package com.example.vuespringbootinicis.pay.controller;

import com.example.vuespringbootinicis.pay.domain.PcPayRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/pay")
@Controller
public class PayController {

    @PostMapping("/PcPay")
    public String PayRequest(Model model, PcPayRequest pcPayRequest) {
        System.out.println(pcPayRequest);
        model.addAttribute("pay", pcPayRequest);
        return "index";
    }

    @GetMapping("/close")
    public String PcClose() {
        System.out.println("close!!!");
        return "close";
    }

    @PostMapping("/return")
    public String pcReturn() {
        return "return";
    }
}
