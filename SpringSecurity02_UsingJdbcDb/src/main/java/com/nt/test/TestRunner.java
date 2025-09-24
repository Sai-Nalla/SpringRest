package com.nt.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	       // System.out.println(encoder.encode("abhi@123")); // should print true
	        
		 String hash = "$2a$10$IXnB/rCaXloFc/8MkJDZ6e/3XxTbDfJ7oBHLGfgn2wOntBYQggJIe";
		// System.out.println(encoder.matches("abhi@123", hash));
	    }
		
	}
	
