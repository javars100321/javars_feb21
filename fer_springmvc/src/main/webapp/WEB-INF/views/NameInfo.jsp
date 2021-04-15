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

		submitForm('contactInfo');
		
	}
</script>

</head>
<body>
	<jsp:include page="Layout/HeaderAndLeftFrame.jsp" />
	
        <form:form method="POST" action="contactInfo" modelAttribute="updateProfileVO">
        
        	  <table border="1">
             	<tr>
                    <td colspan='2' align="center">Name Info</td>
                </tr>
                <tr>
                    <td><form:label path="firstName">First Name</form:label></td>
                    <td><form:input path="firstName"/></td>
                </tr>
                <tr>
                    <td><form:label path="middleName">Middle Name</form:label></td>
                    <td><form:input path="middleName"/></td>
                </tr>
                <tr>
                    <td><form:label path="lastName">Last Name</form:label></td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td colspan='2' align="center"><input type="button" value="Next" onclick="javascript: validateForm()"/></td>
                </tr>
            </table>
        </form:form>
        
	<jsp:include page="Layout/Footer.jsp" />
</body>
</html>