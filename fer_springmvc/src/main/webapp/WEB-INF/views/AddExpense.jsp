
					
<jsp:include page="Layout/HeaderAndLeftFrame.jsp" />		

<script>
	function validateForm() {
		var form = document.DashboardForm;
		var errorMessages = '';
		
		if(form.expenseType.value.trim() == '') {
			errorMessages += 'Please enter expenseType<BR>';
		}
		if(form.date.value.trim() == '') {
			errorMessages += 'Please enter Date<BR>';
		}
		if(form.price.value.trim() == '') {
			errorMessages += 'Please enter Price<BR>';
		}
		if(form.numberOfItems.value.trim() == '') {
			errorMessages += 'Please enter Number of items<BR>';
		}
		if(form.total.value.trim() == '') {
			errorMessages += 'Please enter Total<BR>';
		}
		if(form.bywhom.value.trim() == '') {
			errorMessages += 'Please enter Bywhom<BR>';
		}
		
		if(errorMessages != '') {
			//alert(errorMessages);
			
			
			var errorTdId = document.getElementById('errorTdId');
			errorTdId.innerHTML = errorMessages;
			
			var errorTrId = document.getElementById('errorTrId');
			errorTrId.style.display = '';
			
		} else {
			submitForm('saveExpense');
		}
		
	}
</script>
			
						<table border='1' align='center'>
							<tr>
								<td colspan='2' align='center'>
									Add Expense
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
									<input type='text' name='expenseType'>
								</td>
							</tr>
							
							<tr>
								<td>
									Date <font color='red'>*</font>
								</td>
								<td>
									<input type='text' name='date'>
								</td>
							</tr>
							
							<tr>
								<td>
									Price <font color='red'>*</font>
								</td>
								<td>
									<input type='text' name='price'>
								</td>
							</tr>
							
							<tr>
								<td>
									Number of Items <font color='red'>*</font>
								</td>
								<td>
									<input type='text' name='numberOfItems'>
								</td>
							</tr>
							
							<tr>
								<td>
									Total <font color='red'>*</font>
								</td>
								<td>
									<input type='text' name='total'>
								</td>
							</tr>
							
							<tr>
								<td>
									Bywhom <font color='red'>*</font>
								</td>
								<td>
									<input type='text' name='bywhom'>
								</td>
							</tr>
							
							<tr>
								<td colspan='2' align='center'>
									<input type='button' value='Save Expense' onclick="javascript: validateForm();">
								</td>
							</tr>
						</table>
<jsp:include page="Layout/Footer.jsp" />					
					
				