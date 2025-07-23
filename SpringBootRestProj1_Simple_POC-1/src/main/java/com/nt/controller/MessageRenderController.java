package com.nt.controller;


import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController			//contains both @controller+@Requestbody 
@RequestMapping("/message")  //global path
public class MessageRenderController {
	
	@GetMapping("/generate")
	public ResponseEntity<String> generateWisbody(){
		LocalDateTime date=null;
		String body=null;
		date=LocalDateTime.now();
		int hour=date.getHour();
		if(hour<12)
		body= "Good Morning";
		else if(hour < 18)
			body="Good Afternoon";
		else if(hour<20)
			body="Good Evening";
		else
			body="Good Night";
		HttpStatus status =HttpStatus.OK;
		ResponseEntity<String> res= new ResponseEntity<String>(body,status);
		return res;
		
		
	}

}
