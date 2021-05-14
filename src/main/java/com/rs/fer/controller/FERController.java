package com.rs.fer.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.rs.fer.vo.ResetPassWordVO;

@RestController
public class FERController {

	@Autowired
	private FERService ferService;

	@PostMapping("/registration")
	public ResponseEntity<User> registration(@RequestBody User user) {

		boolean isRegister = ferService.registration(user);

		if (isRegister) {
			return new ResponseEntity(user, HttpStatus.OK);
		} else {
			return new ResponseEntity(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// for Login
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {

		int userId = ferService.login(username, password);

		if (userId > 0) {
			return new ResponseEntity("User is Valid", HttpStatus.OK);
		} else {
			return new ResponseEntity("User is not Valid", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/resetPassword")

	public ResponseEntity<String> resetPassword(@RequestBody ResetPassWordVO reset) {

		boolean isReset = ferService.resetPassword(reset.getUserId(), reset.getOldPassword(), reset.getNewPassword());

		if (isReset) {
			return new ResponseEntity<String>("PassWord reseted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("reset password is faild", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteExpense/{expenseId}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("expenseId") int expenseId) {

		boolean deleteExpense = ferService.deleteExpense(expenseId);
		if (deleteExpense) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/addExpense")
	public ResponseEntity<Expense> createTutorial(@RequestBody Expense expense) {

		boolean isAddExp = ferService.addExpense(expense);
		if (isAddExp) {
			return new ResponseEntity(expense, HttpStatus.OK);
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

	@GetMapping("/getExpenses")
	public ResponseEntity<List<Expense>> getExpenses(@RequestParam int userId) {
		try {
			List<Expense> expenses = new ArrayList<Expense>();
			if (userId > 0) {
				ferService.getExpenses(userId).forEach(expenses::add);
			}
			if (expenses.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(expenses, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/editExpense")
	public ResponseEntity<Expense> editExpense(@RequestBody Expense expense){

		boolean isEditExpense=ferService.editExpense(expense);
		if(isEditExpense) {
			return new ResponseEntity<Expense>(expense, HttpStatus.OK);
		}else 
		{
			return new ResponseEntity<Expense>(expense, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		}
}