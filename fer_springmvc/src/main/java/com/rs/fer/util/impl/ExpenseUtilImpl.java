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

	@Override
	public EditExpenseVO getEditExpenseVO(Expense expense) {
EditExpenseVO editExpenseVO=new EditExpenseVO();
		
		editExpenseVO.setId(expense.getId());
		editExpenseVO.setType(expense.getType());
		editExpenseVO.setDate(expense.getDate());
		editExpenseVO.setPrice(expense.getPrice());
		editExpenseVO.setNumerOfItems(expense.getNumerOfItems());
		editExpenseVO.setTotal(expense.getTotal());
		editExpenseVO.setBywhom(expense.getBywhom());

		
		
		return editExpenseVO;
	}

	@Override
	public Expense getExpenses(EditExpenseVO editExpenseVO, Expense expense) {
		editExpenseVO.setId(expense.getId());
		expense.setType(editExpenseVO.getType());
		expense.setDate(editExpenseVO.getDate());
		expense.setPrice(editExpenseVO.getPrice());
		expense.setNumerOfItems(editExpenseVO.getNumerOfItems());
		expense.setTotal(editExpenseVO.getTotal());
		expense.setBywhom(editExpenseVO.getBywhom());
		
		expense.setUpdated(DateUtil.getCurrentDate());
		
		
		
		
		return expense;
	}


}
