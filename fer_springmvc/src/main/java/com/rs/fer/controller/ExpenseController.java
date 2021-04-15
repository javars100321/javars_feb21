package com.rs.fer.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rs.fer.service.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	@RequestMapping(value = { "/displayAddExpense" }, method = RequestMethod.POST)
	public ModelAndView displayAddExpense() throws IOException {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("AddExpense");
		
		return mv;
	}

	
	
}
