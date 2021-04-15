<%@page import="com.rs.fer.vo.EditExpenseVO"%>

<% 
		EditExpenseVO expense = (EditExpenseVO) session.getAttribute("editExpenseVO");

%>

<jsp:include page="Layout/HeaderAndLeftFrame.jsp" />
<% 
		if (expense == null) {
			out.println("Expense not found");
		} else {

			out.println("<table border='1' align='center'>");
			out.println("   <tr>");
			out.println("<td colspan='2' align='center'>");
			out.println("Edit Expense");
			out.println("         </td>");
			out.println("   </tr>");
			
			out.println("   <tr>");
			out.println("         <td>");
			out.println("Expense Type");
			out.println("         </td>");

			out.println("<td>");
			out.println("<input type='text' name='type' value='" + expense.getType() + "'>");
			out.println("</td>");

			out.println("</tr>");

			out.println("<tr>");

			out.println("<td>");
			out.println("Date");
			out.println("</td>");

			out.println("<td>");
			out.println("<input type='text' name='date' value='" + expense.getDate() + "'>");
			out.println("</td>");

			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>");
			out.println("Price");
			out.println("</td>");

			out.println("<td>");
			out.println("<input type='text' name='price' value='" + expense.getPrice() + "'>");
			out.println("</td>");

			out.println("</tr>");
			out.println("<tr>");

			out.println("<td>");
			out.println("NoOfItems");
			out.println("</td>");

			out.println("<td>");
			out.println("<input type='text' name='numerOfItems' value='" + expense.getNumerOfItems() + "'>");
			out.println("</td>");

			out.println("</tr>");

			out.println("<tr>");

			out.println("<td>");
			out.println("Total");
			out.println("</td>");

			out.println("<td>");
			out.println("<input type='text' name='total' value='" + expense.getTotal() + "'>");
			out.println("</td>");
			out.println("</tr>");

			out.println("<tr>");

			out.println("<td>");
			out.println("By Whom");
			out.println("</td>");

			out.println("<td>");
			out.println("<input type='text' name='bywhom' value='" + expense.getBywhom() + "'>");
			out.println("</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td colspan='2' align='center'>");
			out.println("<input type='button' value='Update Expense' onclick=\"javascript: submitForm('editExpense')\">");
			out.println("</td>");
			
			out.println("</tr>");
			out.println("</table>");

		}
		%>
<jsp:include page="Layout/Footer.jsp" />

