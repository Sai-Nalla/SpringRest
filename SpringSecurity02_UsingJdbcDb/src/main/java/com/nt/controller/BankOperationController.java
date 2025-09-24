package com.nt.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class BankOperationController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	@GetMapping("/offers")
	public String showOffers() {
		return "offers";
	}
	@GetMapping("/balance")
	public String showBalance(Map<String,Integer> map) {
		map.put("balance", new Random().nextInt(10000));
		return "show_balance";
		
	}
	@GetMapping("/approve")
	public String approveLoan(Map<String,Integer> map) {
		map.put("amount", new Random().nextInt(10000));
		return "loan";
	}
	@GetMapping("/denied")
	public String deniedPage() {
		return "denied_page";
	}

}
