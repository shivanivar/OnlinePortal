<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body onload='document.login.username.focus();'>
	
	
	<c:if test="${!empty error}"><div>${error}</div></c:if>
	<c:if test="${!empty message}"><div>${message}</div></c:if>

	<form name='login' action="<c:url value='/home/validate' />" method='POST'>
		<table>
			<tr>
				<td>User Email:</td>
				<td><input type='text' name='useremail' value=''></td>
				<td><springForm:errors path="useremail"></springForm:errors></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
				<td><springForm:errors path="password"></springForm:errors></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit" value="submit" /></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	<a href="/onlineportal/users/newUser">Create a new Account</a>
</body>
</html>