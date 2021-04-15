
					
<jsp:include page="Layout/HeaderAndLeftFrame.jsp" />		

<script>
	function validateForm() {
		var form = document.DashboardForm;

		submitForm('expenseReport');
		
	}
</script>
			
						<table border='1' align='center'>
							<tr>
								<td colspan='2' align='center'>
									Expense Report
								</td>
							</tr>
							
							<tr id='errorTrId' style='display:none;'>
								<td colspan='2' align='left' id='errorTdId' style='color:red;'>
									
								</td>
							</tr>
							
							<tr>
								<td>
									Expense Type <font color='red'>*</font>
								</td>
								<td>
									<input type='text' name='type'>
								</td>
							</tr>
							
							<tr>
								<td>
									From Date <font color='red'>*</font>
								</td>
								<td>
									<input type='text' name='fromDate'>
								</td>
							</tr>
							
							<tr>
								<td>
									To Date <font color='red'>*</font>
								</td>
								<td>
									<input type='text' name='toDate'>
								</td>
							</tr>
							
							<tr>
								<td colspan='2' align='center'>
									<input type='button' value='Get Expense Report' onclick="javascript: validateForm();">
								</td>
							</tr>
						</table>
<jsp:include page="Layout/Footer.jsp" />					
					
				