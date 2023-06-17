package com.programmingtechie.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programmingtechie.orderservice.dto.OrderRequest;
import com.programmingtechie.orderservice.service.Orderservice;

@RestController
@RequestMapping("/api/order")
public class OrderController {
@Autowired
private Orderservice orderService;
	@PostMapping
	public String placeOrder(@RequestBody OrderRequest orderRequest) {
	System.out.println(orderRequest);
		orderService.placeOrder(orderRequest);
		return "Order placed successfully";
	}
}
