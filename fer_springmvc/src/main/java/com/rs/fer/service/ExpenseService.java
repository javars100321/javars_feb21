package com.rs.fer.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.rs.fer.entity.Expense;
import com.rs.fer.vo.AddExpenseVO;

public interface ExpenseService {

	boolean addExpense(AddExpenseVO addExpenseVO, HttpSession session);

	boolean deleteExpense(int expenseId);

	List<Expense> getExpenses(HttpSession session);
}
