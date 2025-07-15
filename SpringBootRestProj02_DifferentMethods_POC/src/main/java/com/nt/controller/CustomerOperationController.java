package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerOperationController {
	
	@GetMapping("/report")
	public ResponseEntity<String> showCustomersReport(){
		return new ResponseEntity<String>(" GET MODE  SHOW REPORT",HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(){
		return new ResponseEntity<String>(" Post MODE  register customer",HttpStatus.OK);
	}

	@PutMapping("/modify")
	public ResponseEntity<String> UpdateCustomer(){
		return new ResponseEntity<String>(" Update Custonme",HttpStatus.OK);
	}

	@PatchMapping("/pmodify")
	public ResponseEntity<String> UpdateCustomeById(){
		return new ResponseEntity<String>(" Update Customer By iDT",HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<String> removeCustomer(){
		return new ResponseEntity<String>(" Delete Customer ",HttpStatus.OK);
	}


}
