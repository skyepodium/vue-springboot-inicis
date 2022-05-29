package com.example.vuespringbootinicis.pay.service;

import com.example.vuespringbootinicis.pay.domain.OrderData;
import com.example.vuespringbootinicis.pay.repository.PayRepository;
import com.example.vuespringbootinicis.utils.HashUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class PayService {

    private final PayRepository payRepository;

    public void saveOrder(String orderNumber, long timestamp, String signature, int price) {
        payRepository.saveOrder(orderNumber, timestamp, signature, price);
    }

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public String checkPcReturn(String resultCode, String resultMsg, String mid, String orderNumber, String authToken, String authUrl, String netCancelUrl, String charset, String merchantData) throws IllegalAccessException, IOException, InterruptedException {
        if(!"0000".equals(resultCode)) throw new IllegalAccessException("결제 실패");

        OrderData orderData = payRepository.getOrder(orderNumber);
        // form parameters
        Map<Object, Object> data = new HashMap<>();
        data.put("mid", mid);
        data.put("authToken", authToken);
        data.put("timestamp", orderData.getTimestamp());
        data.put("signature", HashUtils.getAuthSignature(authToken, orderData.getTimestamp()));
        data.put("charset", charset);
        data.put("format", "JSON");
        data.put("price", orderData.getPrice());

        HttpRequest request = HttpRequest.newBuilder()
                .POST(ofFormData(data))
                .uri(URI.create(authUrl))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public static HttpRequest.BodyPublisher ofFormData(Map<Object, Object> data) {
        var builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
        }
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }

}
