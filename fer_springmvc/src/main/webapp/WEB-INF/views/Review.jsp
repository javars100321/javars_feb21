<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<script>
	function validateForm() {
		var form = document.DashboardForm;

		submitForm('updateUser');
		
	}
</script>
</head>
<body>
	<jsp:include page="Layout/HeaderAndLeftFrame.jsp" />
	
        <form:form method="POST" action="updateUser" modelAttribute="updateProfileVO">
        
        	  <table border="1">
             	
             	<tr>
                    <td><form:label path="firstName">First Name</form:label></td>
                    <td><form:input path="firstName" disabled="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="middleName">Middle Name</form:label></td>
                    <td><form:input path="middleName" disabled="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="lastName">Last Name</form:label></td>
                    <td><form:input path="lastName" disabled="true"/></td>
                </tr>
                
             	 <tr>
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email" disabled="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="mobile">Mobile</form:label></td>
                    <td><form:input path="mobile" disabled="true"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="lineOne">Line 1</form:label></td>
                    <td><form:input path="lineOne" disabled="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="lineTwo">Line 2</form:label></td>
                    <td><form:input path="lineTwo" disabled="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="city">City</form:label></td>
                    <td><form:input path="city" disabled="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="state">State</form:label></td>
                    <td><form:input path="state" disabled="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="pinCode">Pincode</form:label></td>
                    <td><form:input path="pinCode" disabled="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="country">Country</form:label></td>
                    <td><form:input path="country" disabled="true"/></td>
                </tr>
                <tr>
                     <td colspan='2' align="center"><input type="button" value="Update" onclick="javascript: validateForm()"/></td>
                </tr>
            </table>
        </form:form>
        
	<jsp:include page="Layout/Footer.jsp" />
</body>
</html>