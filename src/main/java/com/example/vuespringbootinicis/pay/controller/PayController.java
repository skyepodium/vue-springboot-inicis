package com.example.vuespringbootinicis.pay.controller;

import com.example.vuespringbootinicis.pay.domain.PcPayRequest;
import com.example.vuespringbootinicis.pay.domain.PcPayReturn;
import com.example.vuespringbootinicis.pay.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequiredArgsConstructor
@RequestMapping("/api/v1/pay")
@Controller
public class PayController {

    private final PayService payService;

    @PostMapping("/PcPay")
    public String PayRequest(Model model, PcPayRequest pcPayRequest) {
        payService.saveOrder(pcPayRequest.getOid(), pcPayRequest.getTimestamp(), pcPayRequest.getSignature(), pcPayRequest.getPrice());
        model.addAttribute("pay", pcPayRequest);
        return "index";
    }

    @GetMapping("/close")
    public String PcClose() {
        return "close";
    }

    @ResponseBody
    @PostMapping("/return")
    public String pcReturn(PcPayReturn pcPayReturn) throws IllegalAccessException, IOException, InterruptedException {
        return payService.checkPcReturn(pcPayReturn.getResultCode(), pcPayReturn.getResultMsg(), pcPayReturn.getMid(), pcPayReturn.getOrderNumber(), pcPayReturn.getAuthToken(), pcPayReturn.getAuthUrl(), pcPayReturn.getNetCancelUrl(), pcPayReturn.getCharset(), pcPayReturn.getMerchantData());
    }
}
