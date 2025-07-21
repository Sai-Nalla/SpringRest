package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Customer;

@RestController
@RequestMapping("/customer")
public class RequestParamOperationController {

	@GetMapping("/report/{no}/{name}")
	public String reportData(@PathVariable String name,
							@PathVariable Integer no) {
		
		return name+" -->"+no;
	}
	
	@GetMapping("/report/101/raja")
	public String reportData2(@PathVariable(required = false) String name,
							@PathVariable(required = false) Integer no) {
		System.out.println("RequestParamOperationController.reportData2()");
		return "forFetchData2";
	}
	@GetMapping("/report/101/{name}z")
	public String reportData3(@PathVariable(required = false) String name,
							@PathVariable(required = false) Integer no) {
		
		
		
		return "forFetchData3";
	}
	
}
