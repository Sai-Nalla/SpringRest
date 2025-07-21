package com.nt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Customer;

@RestController
@RequestMapping("/customer")
public class JsonToObjController {
	
	@PostMapping("/save")
	public String showCustomerDetails(@RequestBody Customer cust) {
		
		return cust.toString();
		
	}
	

}
