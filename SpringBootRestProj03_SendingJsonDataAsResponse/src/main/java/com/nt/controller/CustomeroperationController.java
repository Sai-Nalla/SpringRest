package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Customer;

@RestController
@RequestMapping("/customer")
public class CustomeroperationController {

	@PostMapping("/register")
	public ResponseEntity<Customer> saveCustomer(){
		//Customer cust=new Customer(101, "Murali",102.0f);
		
		Company comp=new Company(1001,"Infosys","Hyd");
		Customer cust=new Customer(1,"Ram",102.0f,
				new String[] {"red","white"},
				List.of("Krishna","Vishnu"),
				Set.of(99999L,8888L),
				Map.of("aadhar",328285L,"pan",87829L),
				comp	
				);
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);		
		
	}
	
}
