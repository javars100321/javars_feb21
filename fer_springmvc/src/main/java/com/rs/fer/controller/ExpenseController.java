package com.rs.fer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rs.fer.entity.Expense;
import com.rs.fer.service.ExpenseService;
import com.rs.fer.vo.AddExpenseVO;
import com.rs.fer.vo.EditExpenseVO;
import com.rs.fer.vo.ExpenseReportSelectionVO;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;

	
	
}
