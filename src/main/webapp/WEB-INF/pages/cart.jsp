<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.ecom.springmvc.model.Item"%>
<%@ page import="com.ecom.springmvc.model.User"%>
<%@ page session="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<%
		User user = (User) session.getAttribute("user");
		if (user != null) {
			out.println("<a href=\"\\onlineportal\\home\\logout\" >Logout</a>");
			out.println("                 ");
			out.println("<a href=\"\\onlineportal\\home\\logout\" >Order History</a>");

		} else {
			out.println("<a href=\"\\onlineportal\\home\\loginPage\" >Login</a>");
		}
	%>
	<c:set var="cartlist" value="${sessionScope.cart}" />
	<table class="tg">
		<tr>

			<th width="120">Sr .no</th>
			<th width="60">Product Image</th>
			<th width="60">Product Name</th>
			<th width="60">Product Price</th>
			<th width="60">Product Quantity</th>
		</tr>
		<c:forEach items="${cartlist}" var="cartlist" varStatus="i">
			<tr>
				<td><c:out value="${i.count}" /></td>
				<td><c:out value="${cartlist.product.image}" /></td>
				<td><c:out value="${cartlist.product.name}" /></td>
				<td><c:out value="${cartlist.product.price}" /></td>
				<td><c:out value="${cartlist.quantity}" /></td>
			</tr>
		</c:forEach>
	</table>
	<form action="/onlineportal/orders/order" method="POST">
		<input type="submit" value="Confirm Order" name="confirmOrder">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</body>
</html>