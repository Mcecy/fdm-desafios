package com.mcecy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcecy.entities.Order;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {
        double amount = order.getBasic();
        double discount = 1.00 - (order.getDiscount() / 100);
        return shippingService.shipment(order) + (amount * discount);
    }
}
