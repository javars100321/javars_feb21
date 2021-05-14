package com.rs.fer.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.bean.Expense;
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
			return new ResponseEntity("User is Valid", HttpStatus.OK);
		} else {
			return new ResponseEntity("User is not Valid", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/resetPassword/{userId}")
	
	public ResponseEntity<String> resetPassword(@PathVariable("userId") int userId,@RequestParam String oldPassword, @RequestParam String newPassword) {
		
		boolean isReset = ferService.resetPassword(userId, oldPassword, newPassword);
		
		if(isReset) {
			return new ResponseEntity("PassWord reseted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity("reset password is faild", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@DeleteMapping("/deleteExpense/{expenseId}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("expenseId") int expenseId) {
		
			boolean deleteExpense=ferService.deleteExpense(expenseId);
			if(deleteExpense) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/addExpense")
	public ResponseEntity<Expense> createTutorial(@RequestBody Expense expense) {
		
		boolean isAddExp = ferService.addExpense(expense);
		if(isAddExp) {
			return new ResponseEntity(expense,   HttpStatus.OK);
		} else {
			return new ResponseEntity(expense, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	@GetMapping("/expenseReport/{userId}")
	public ResponseEntity<List<Expense>> expenseReport(@PathVariable("userId") int userId, @RequestParam String type,
			@RequestParam String fromDate, @RequestParam String toDate) throws IOException {

		List<Expense> expenseReport = (List<Expense>) ferService.expenseReport(userId, type, fromDate, toDate);

		if (expenseReport.isEmpty()) {
			return new ResponseEntity(expenseReport, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity(expenseReport, HttpStatus.OK);
		}
}
}