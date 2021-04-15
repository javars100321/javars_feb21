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

	@RequestMapping(value = "/saveExpense", method = RequestMethod.POST)
	public ModelAndView saveExpense(@ModelAttribute AddExpenseVO addExpenseVO, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();

		boolean isAdded = expenseService.addExpense(addExpenseVO, session);
		if (isAdded) {
			mv.addObject("status", "Expense Added successfully");
		} else {
			mv.addObject("status", "Expense Added failed");
		}

		mv.setViewName("Status");
		return mv;
	}

	@RequestMapping(value = { "/deleteExpenseOptions" }, method = RequestMethod.POST)
	public ModelAndView deleteExpenseOptions(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		List<Expense> expenses = expenseService.getExpenses(session);
		if (CollectionUtils.isEmpty(expenses)) {
			mv.addObject("status", "Expense not found");
		} else {
			mv.addObject("expenses", expenses);
			session.setAttribute("expenses", expenses);
		}
		mv.setViewName("DeleteExpenseOptions");
		return mv;
	}

	@RequestMapping(value = { "/deleteExpense" }, method = RequestMethod.POST)
	public ModelAndView deleteExpense(@RequestParam int expenseId, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();
		EditExpenseVO editExpenseVO = expenseService.getExpense(expenseId);
		session.setAttribute("expenseId", expenseId);

		boolean isDeleted = expenseService.deleteExpense(expenseId);
		if (isDeleted) {
			mv.addObject("status", "Expense deleted successfully");
		} else {
			mv.addObject("status", "Expense delete is failed");
		}
		mv.setViewName("Status");
		return mv;
	}

	@RequestMapping(value = "/editExpenseOptions", method = RequestMethod.POST)
	public ModelAndView editExpenseOptions(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		List<Expense> expenses = expenseService.getExpenses(session);

		if (CollectionUtils.isEmpty(expenses)) {
			mv.addObject("status", "Expense not Found");

		} else {
			mv.addObject("expenses", expenses);
			session.setAttribute("expenses", expenses);

		}
		mv.setViewName("EditExpenseOptions");

		return mv;
	}

	@RequestMapping(value = "/displayEditExpense", method = RequestMethod.POST)
	public ModelAndView displayEditExpense(@RequestParam int expenseId, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();
		EditExpenseVO editExpenseVO = expenseService.getExpense(expenseId);
		mv.addObject("editExpenseVO", editExpenseVO);
		session.setAttribute("expenseId", expenseId);
		session.setAttribute("editExpenseVO", editExpenseVO);
		mv.setViewName("EditExpense");

		return mv;
	}

	@RequestMapping(value = "/editExpense", method = RequestMethod.POST)
	public ModelAndView editExpense(@ModelAttribute EditExpenseVO editExpenseVO, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		boolean isEdited = expenseService.editExpense(editExpenseVO, session);

		if (isEdited) {
			mv.addObject("status", "Expense updated successfully");

		} else {
			mv.addObject("status", "Expense update is Failed");

		}
		mv.setViewName("Status");

		return mv;
	}

}
