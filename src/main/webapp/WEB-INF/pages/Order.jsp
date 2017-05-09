<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="com.ecom.springmvc.model.User"%>
<%@ page session="true"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Order Page</title>
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


	<h3>Order History</h3>
	<c:if test="${!empty listOrders}">
		<table class="tg">
			<tr>

				<th width="120">Product Code</th>
				<th width="60">Product Image</th>
				<th width="60">Product Name</th>
				<th width="60">Product Price</th>
				<th width="60">Product Date</th>
			</tr>
			<c:forEach items="${listProducts}" var="product">
				<tr>
					<td>${product.code}</td>
					<td>${product.image}</td>
					<td>${product.name }</td>
					<td>${product.price}</td>
					<td>${product.date}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>