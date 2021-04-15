package com.rs.fer.service;

import javax.servlet.http.HttpSession;

import com.rs.fer.vo.AddExpenseVO;

public interface ExpenseService {
	
	
	boolean addExpense(AddExpenseVO addExpenseVO, HttpSession session);

	boolean deleteExpense(int expenseId);
}
