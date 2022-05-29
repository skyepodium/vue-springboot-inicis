package com.example.vuespringbootinicis.pay.repository;

import com.example.vuespringbootinicis.pay.domain.OrderData;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PayRepository {

    public Map<String, OrderData> m = new HashMap<>();

    public void saveOrder(String orderNumber, long timestamp, String signature, int price) {
        this.m.put(orderNumber, new OrderData(timestamp, signature, price));
    }

    public OrderData getOrder(String orderNumber) {
        return this.m.get(orderNumber);
    }
}
