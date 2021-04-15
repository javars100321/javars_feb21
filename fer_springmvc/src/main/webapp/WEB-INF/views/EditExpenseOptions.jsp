<%@page import="com.rs.fer.entity.Expense"%>
<%@page import="java.util.List"%>



<script>
	function validate() {
		if (document.getElementById("expenseId").value == "") {
			//alert("Please select value");
			// document.getElementById("expenseId").focus(); 
			var errrDivId = document.getElementById('errrDivId');
			errrDivId.innerHTML = 'Please select value';
			errrDivId.style.display = '';
			// return false;
		} else {
			submitForm('displayEditExpense');
		}
	}
</script>
<%
	List<Expense> expenses = (List<Expense>) session.getAttribute("expenses");

	if (expenses == null || expenses.isEmpty()) {
		out.println("Expense not Found...");
	} else {
%>
<jsp:include page="Layout/HeaderAndLeftFrame.jsp" />
<div id='errrDivId' style='display: none; color: red;'></div>
<%
	out.println("expense ID:");
		out.println("<select name='expenseId' id='expenseId'>");
		out.println("<option value=''>Please Select expense</option>");

		int value = 0;
		String description = null;
		for (Expense expense : expenses) {
			value = expense.getId();

			description = expense.getType() + "," + expense.getDate() + "," + expense.getBywhom();

			out.println("<option value='" + value + "'>" + description + "</option>");

		}
		out.println("</select>");
		out.println("<input type='button' value='Delete' onclick='javascript: validate()'>");
%>

<jsp:include page="Layout/Footer.jsp" />
<%
	}
%>
