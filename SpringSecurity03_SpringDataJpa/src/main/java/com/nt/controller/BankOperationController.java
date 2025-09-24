package com.nt.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.model.UserDetail;
import com.nt.service.IUserService;

@Controller
@RequestMapping("/bank")
public class BankOperationController {
	
	@Autowired
	private IUserService service;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@RequestMapping("/showlogin")
	public String showLoginPage() {
		return "custom_login";
	}
	
	

	@GetMapping("/register")
	public String showregistrationPage(@ModelAttribute("userInfo") UserDetail user) {
		
		return "user_register";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("userInfo") UserDetail user,
				Map<String,String> map) {
		
		String messa=service.saveUsers(user);
		map.put("msg", messa);
		System.out.println(messa);
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
