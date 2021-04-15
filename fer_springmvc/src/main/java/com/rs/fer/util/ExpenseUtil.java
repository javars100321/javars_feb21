package com.rs.fer.util;

import com.rs.fer.entity.Expense;
import com.rs.fer.vo.AddExpenseVO;
import com.rs.fer.vo.EditExpenseVO;

public interface ExpenseUtil {

	Expense getExpense(AddExpenseVO addExpenseVO);

	EditExpenseVO getEditExpenseVO(Expense expense);

	Expense getExpenses(EditExpenseVO editExpenseVO, Expense expense);

}
