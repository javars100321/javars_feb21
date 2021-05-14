package com.rs.fer.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.repository.ExpenseRepository;
import com.rs.fer.repository.UserRepository;
import com.rs.fer.service.FERService;

@Service
public class FERServiceImpl implements FERService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Transactional
	@Override
	public boolean registration(User user) {
		boolean isRegister = false;
		
		user = userRepository.save(user);
		
		isRegister = user.getUserId() > 0;
		
		return isRegister;
	}

	//for login
	@Override
	public int login(String username, String password) {
		 
		List<User> users = userRepository.findByUsernameAndPassword(username, password);
		
		if(users != null && !users.isEmpty()) {
			return users.get(0).getUserId();
		} 
		
		return 0;
		
	}

	@Override
	//addExpense
	public boolean addExpense(Expense expense) {
		boolean expenseAdd = false;

		expense = expenseRepository.save(expense);
		
		expenseAdd = expense.getExpenseId() > 0;

		return expenseAdd;
	}

	@Override
	public Expense getExpense(int expenseId) {
		return expenseRepository.findById(expenseId).get();
	}

	@Override
	public List<Expense> getExpenses(int userId) {
		return expenseRepository.findByUserId(userId);
	}

	@Override
	public boolean editExpense(Expense expense) {
		
		boolean expenseEdit = false;
		
		expense = expenseRepository.save(expense);
		
		expenseEdit = expense.getExpenseId() > 0;

		
		return expenseEdit;
	}

	@Override
	public boolean deleteExpense(int expenseId) {
		boolean expensedelete = false;
		
		
		return expensedelete;
	}

	@Override
	public boolean resetPassword(int userId, String currentPassword, String newPassword) {
		boolean isreset = false;
		

		return isreset;
	}

	@Override
	public List<Expense> expenseReport(int userId, String expenseType, String fromDate, String toDate) {
		List<Expense> isExpenseReport = new ArrayList<Expense>();
		
		
		return isExpenseReport;

	}

	@Override
	public User getUser(int userId) {
		User user = null;
		
		return user;
	}

	@Override
	public boolean updateUser(User user) {

		
		return true;

	}

}