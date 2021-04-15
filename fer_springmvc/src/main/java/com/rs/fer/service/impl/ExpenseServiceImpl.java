package com.rs.fer.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

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

	
}
