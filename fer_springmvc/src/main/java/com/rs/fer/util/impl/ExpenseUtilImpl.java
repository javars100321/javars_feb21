package com.rs.fer.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.entity.Expense;
import com.rs.fer.util.ExpenseUtil;
import com.rs.fer.vo.AddExpenseVO;
import com.rs.fer.vo.EditExpenseVO;

@Component
public class ExpenseUtilImpl implements ExpenseUtil{
	
	@Override
	public Expense getExpense(AddExpenseVO addExpenseVO) {
		
		Expense expense=new Expense();
		expense.setType(addExpenseVO.getType());
		expense.setDate(addExpenseVO.getDate());
		expense.setPrice(addExpenseVO.getPrice());
		expense.setNumerOfItems(addExpenseVO.getNumerOfItems());
		expense.setTotal(addExpenseVO.getTotal());
		expense.setBywhom(addExpenseVO.getBywhom());
		
		expense.setCreated(DateUtil.getCurrentDate());
		return expense;
	}


}
