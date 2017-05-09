<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
</head>
<body>
<h2>Application Error, please contact support.</h2>

<h3>Debug Information:</h3>

Requested URL= ${url}<br><br>

Exception= ${exception.message}<br><br>

<%-- <strong>Exception Stack Trace</strong><br>
<c:forEach items="${exception.stackTrace}" var="ste">
	${ste}
</c:forEach> --%>

</body>
</html>