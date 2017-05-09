<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create your Account</title>
<style>
.error {
color: #ff0000;
font-style: italic;
}
</style>
</head>
<body>
<form:form name='newuser' action="user/add" method='POST'>
		<table>
			<tr>
			<td>User Name</td>
			<td><input type='text' name='name' value='' /></td>
			</tr>
			<tr>
				<td>User Email</td>
				<td><input type='text' name='user_email' value='' /></td>
				<td><form:errors path="user_email" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type='password' name='password' /></td>
				<td><form:errors path="password" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name='user_address'/></td>
				<td><form:errors path="user_address" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Phone No.</td>
				<td><input type="text" name='user_phone' /></td>
				<td><form:errors path="user_phone" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit" value="submit" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>