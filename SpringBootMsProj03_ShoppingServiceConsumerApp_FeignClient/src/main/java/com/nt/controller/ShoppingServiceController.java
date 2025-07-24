package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.IBillingServiceRestConsumer;

@RestController
@RequestMapping("/shopping")
public class ShoppingServiceController {
	
	@Autowired
	private IBillingServiceRestConsumer consumer;
	
	@GetMapping("/info")
	public String  displayShoppingdetails() {
		
		return "Shopiing details"+consumer.fetchBillDetails();
	}
}
