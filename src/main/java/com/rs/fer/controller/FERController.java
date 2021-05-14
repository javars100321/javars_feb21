package com.rs.fer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;

@RestController
public class FERController {

	@Autowired
	private FERService ferService;

	@PostMapping("/registration")
	public ResponseEntity<User> registration(@RequestBody User user) {
		
		boolean isRegister = ferService.registration(user);
		
		if(isRegister) {
			return new ResponseEntity(user, HttpStatus.OK);
		} else {
			return new ResponseEntity(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
		
	}
	//for Login 
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
		
		int userId = ferService.login(username, password);
		
		if(userId > 0) {
			return new ResponseEntity("User      is Valid", HttpStatus.OK);
		} else {
			return new ResponseEntity("User is not Valid", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
