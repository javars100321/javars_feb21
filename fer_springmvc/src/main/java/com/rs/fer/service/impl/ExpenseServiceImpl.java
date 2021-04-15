package com.rs.fer.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.fer.entity.Expense;
import com.rs.fer.repository.ExpenseRepository;
import com.rs.fer.service.ExpenseService;
import com.rs.fer.util.ExpenseUtil;
import com.rs.fer.util.impl.FERUtil;
import com.rs.fer.vo.AddExpenseVO;
import com.rs.fer.vo.EditExpenseVO;
import com.rs.fer.vo.ExpenseReportSelectionVO;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;

	@Autowired
	ExpenseUtil expenseUtil;

	@Transactional
	@Override
	public boolean addExpense(AddExpenseVO addExpenseVO, HttpSession session) {

		boolean isAddExpense = false;
		Expense expense = expenseUtil.getExpense(addExpenseVO);
		expense.setUserId(FERUtil.getUserId(session));
		try {
			expenseRepository.save(expense);
			isAddExpense = true;
		} catch (Exception ex) {
			isAddExpense = false;
		}
		return isAddExpense;
	}

	@Override
	public boolean deleteExpense(int expenseId) {
		expenseRepository.deleteById(expenseId);
		return true;
	}

	@Override
	public List<Expense> getExpenses(HttpSession session) {
		List<Expense> expenses = null;

		expenses = expenseRepository.findByUserId(FERUtil.getUserId(session));

		return expenses;
	}

	@Override
	public EditExpenseVO getExpense(int expenseId) {
		EditExpenseVO editExpenseVO = new EditExpenseVO();
		Expense expense = expenseRepository.findById(expenseId).get();
		editExpenseVO = expenseUtil.getEditExpenseVO(expense);
		return editExpenseVO;
	}

	@Override
	public boolean editExpense(EditExpenseVO editExpenseVO, HttpSession session) {
		int expenseId = FERUtil.getId(session);
		Expense expense = expenseRepository.findById(expenseId).get();
		expense = expenseUtil.getExpenses(editExpenseVO, expense);

		expense.setUserId(FERUtil.getUserId(session));
		try {
			expenseRepository.save(expense);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
