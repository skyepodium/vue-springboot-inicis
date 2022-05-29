package com.example.vuespringbootinicis.pay.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class PcPayReturn {
    private String resultCode;
    private String resultMsg;
    private String mid;
    private String orderNumber;
    private String authToken;
    private String authUrl;
    private String netCancelUrl;
    private String charset;
    private String merchantData;
}
