package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Customer;

@RestController
@RequestMapping("/customer")
public class RequestParamOperationController {

	@GetMapping("/report")
	public String reportData(@RequestParam(required = false,value="name") String cname,
								@RequestParam Integer no) {
		
		return cname+" -->"+no;
	}
	
}
