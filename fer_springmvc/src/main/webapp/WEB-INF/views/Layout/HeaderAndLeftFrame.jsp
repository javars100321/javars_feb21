<html>
	<head>
		<title>FER-Dashboard</title>
		
		<script>
			function submitForm(nextPath) {
				var form = document.DashboardForm;
			
				form.action = nextPath;
				form.method = 'post';
				
				form.submit();
			}
		</script>
	</head>
	
	<body>
		<form name='DashboardForm'>
			<table border='1' align='center' height='600px' width='800px'>
				<tr height='100px'>
					<td colspan='2' align='center'>
						Family Maintenance Report  User: ${username}
						
						
						
						
						
						</td>
				</tr>
				
				<tr>
					<td width='150px'>
						<br><br>
						<a href="javascript: submitForm('displayAddExpense')">Add Expense</a>
						<br><br>
						<a href="javascript: submitForm('editExpenseOptions')">Edit Expense</a>
						<br><br>
						<a href='DeleteExpenseOptions.html'>Delete Expense</a>
						<br><br>
						<a href="javascript: submitForm('expenseReportSelection')">Expense Report</a>
						<br><br>
						<a href='ResetPassword.html'>Reset Password</a>
						<br><br>
						<a href="javascript: submitForm('nameInfo')">Update Profile</a>
						<br><br>
					</td>
					<td align='center'>