package com.nt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Actor;

@RestController
@RequestMapping("/actor")
public class ActorOperationController {
	
	@GetMapping("/wish")
	public ResponseEntity<String> displayWishMsg(){
		return new ResponseEntity<String>("Good Morning",HttpStatus.OK);
	}
	
	@GetMapping("/wish/{id}/{name}")
	
	public ResponseEntity<String> displayCustomName(@PathVariable int id,@PathVariable String name){
		
		String msg=" hello "+name+" your numner is "+id;
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

	
	@PostMapping("/register")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor)
	{
		return new ResponseEntity<String>(actor.toString(),HttpStatus.OK);
	}
	
	@GetMapping("/find")
	public ResponseEntity<List<Actor>> fetchActor(){
		 return new ResponseEntity<List<Actor>>( List.of(new Actor(2,"Ramu","Warangal"),
				 									new Actor(2,"Vijay","Kansas"),
				 									new Actor(3,"Praneetha","Ongole")),
				 									HttpStatus.OK);
	}
} 
