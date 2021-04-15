<html>
	<head>
		<title>FER-Login</title>
	</head>
	
	<body>
		<form action='login' method='post'>
			${status}
			<table border='1' align='center'>
				<tr>
					<td colspan='2' align='center'>
						Login
					</td>
				</tr>
				
				<tr>
					<td>
						Username
					</td>
					<td>
						<input type='text' name='username'>
					</td>
				</tr>
				
				<tr>
					<td>
						Password
					</td>
					<td>
						<input type='password' name='password'>
					</td>
				</tr>
				
				<tr>
					<td colspan='2' align='center'>
						<input type='submit' value='Login'>
						&nbsp;&nbsp;
						<a href='registration'>Registration</a>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>