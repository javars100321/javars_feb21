<html>
	<head>
		<title>FER-Registration</title>
		
		<script>
			function validateForm() {
				var form = document.RegistrationForm;
				var errorMessages = '';
				
				if(form.firstName.value.trim() == '') {
					errorMessages += 'Please enter First Name<BR>';
				}
				if(form.lastName.value.trim() == '') {
					errorMessages += 'Please enter Last Name<BR>';
				}
				if(form.email.value.trim() == '') {
					errorMessages += 'Please enter Email<BR>';
				}
				if(form.username.value.trim() == '') {
					errorMessages += 'Please enter Username<BR>';
				}
				if(form.password.value.trim() == '') {
					errorMessages += 'Please enter Password<BR>';
				}
				if(form.mobile.value.trim() == '') {
					errorMessages += 'Please enter Mobile<BR>';
				}
				
				if(errorMessages != '') {
					//alert(errorMessages);
					
					
					var errorTdId = document.getElementById('errorTdId');
					errorTdId.innerHTML = errorMessages;
					
					var errorTrId = document.getElementById('errorTrId');
					errorTrId.style.display = '';
					
				} else {
					form.submit();
				}
				
			}
			
			function validateEmail(email) {
				  var xhttp = new XMLHttpRequest();
				  var url = "FER_AJAX.jsp?email="+email;
				  
				  xhttp.onreadystatechange = function() {
				    if (this.readyState == 4 && this.status == 200) {
				     
				     	var emailTrId = document.getElementById('emailTrId');
				     	var emailTdId = document.getElementById('emailTdId');
				     	
				     	if(this.responseText.trim() == 'Y') {
				     		emailTdId.innerHTML = 'Email is available';
				     		emailTdId.style.color = 'green';
				     	} else {
				     		emailTdId.innerHTML = 'Email is not available';
				     		emailTdId.style.color = 'red';
				     	}
				     
				     	emailTrId.style.display = '';
				     	
				     
				    }
				  };
				  xhttp.open("GET", url, true);
				  xhttp.send();
			}
			
		</script>
	</head>
	
	<body>
		<form action='registration' method='post' name='RegistrationForm'>
			${status}
			<table border='1' align='center'>
				<tr>
					<td colspan='2' align='center'>
						Registration
					</td>
				</tr>
				
				<tr id='errorTrId' style='display:none;'>
					<td colspan='2' align='left' id='errorTdId' style='color:red;'>
						
					</td>
				</tr>
				
				<tr>
					<td>
						First Name <font color='red'>*</font>
					</td>
					<td>
						<input type='text' name='firstName' value="<%=request.getParameter("firstName")%>">
					</td>
				</tr>
				
				<tr>
					<td>
						Middle Name
					</td>
					<td>
						<input type='text' name='middleName'>
					</td>
				</tr>
				
				<tr>
					<td>
						Last Name <font color='red'>*</font>
					</td>
					<td>
						<input type='text' name='lastName'>
					</td>
				</tr>
				
				<tr>
					<td>
						Email <font color='red'>*</font>
					</td>
					<td>
						<input type='text' name='email' onchange="javascript: validateEmail(this.value)">
					</td>
				</tr>
				
				<tr id='emailTrId' style='display:none;'>
					<td colspan='2' align='left' id='emailTdId'>
						
					</td>
				</tr>
				
				<tr>
					<td>
						Username <font color='red'>*</font>
					</td>
					<td>
						<input type='text' name='username'>
					</td>
				</tr>
				
				<tr>
					<td>
						Password <font color='red'>*</font>
					</td>
					<td>
						<input type='password' name='password'>
					</td>
				</tr>
				
				<tr>
					<td>
						Mobile <font color='red'>*</font>
					</td>
					<td>
						<input type='text' name='mobile'>
					</td>
				</tr>
				
				<tr>
					<td colspan='2' align='center'>
						<input type='button' value='Register' onclick="javascript: validateForm()">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>