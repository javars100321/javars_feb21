<%@page import="com.rs.fer.entity.Expense"%>
<%@page import="java.util.List"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
	List<Expense> expenses = (List<Expense>) session.getAttribute("expenses");

	if (expenses == null || expenses.isEmpty()) {
		out.println("Expense not Found...");
	}
%>
<jsp:include page="Layout/HeaderAndLeftFrame.jsp" />
<div id='errrDivId' style='display: none; color: red;'></div>
<table border="1">
	<tr>
		<td>Expense Id</td>
		<td>Expense Type</td>
		<td>Date</td>
		<td>Price</td>
		<td>Number of Items</td>
		<td>Total</td>
		<td>Bywhom</td>
	</tr>
	<c:forEach var="expense" items="${expenses}">
	<tr>
		<td>${expense.id}</td>
		<td>${expense.type}</td>
		<td>${expense.date}</td>
		<td>${expense.price}</td>
		<td>${expense.numerOfItems}</td>
		<td>${expense.total}</td>
		<td>${expense.bywhom}</td>
	</tr>
	</c:forEach>
</table>

<jsp:include page="Layout/Footer.jsp" />

