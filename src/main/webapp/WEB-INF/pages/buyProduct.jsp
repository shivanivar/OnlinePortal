<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<%@ page import="com.ecom.springmvc.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase Product</title>
<script type="text/javascript">
function fun(code){
	document.getElementById("code").value=code;
	validateUser();
}
function validateUser()
{
	var property="<%=session.getAttribute("user")%>";	
	if(property === 'null')
		{
		alert("Login to buy Products");
		document.getElementById("form1").action ="/onlineportal/home/loginPage";
		
		}
	else
		document.getElementsByName("form1").submit();
}
</script>
</head>
<body>
<!-- 	<form action="/onlineportal/home/loginPage" method="POST">
		<input type="submit" value="Login" name="loginButton">
	</form> -->
	<%
        User user =  (User)session.getAttribute("user");
        if(user !=null)
            {
             out.println("<a href=\"\\onlineportal\\home\\logout\" >Logout</a>");
             out.println("                 ");
             out.println("<a href=\"\\onlineportal\\orders\\orderhistory\" >Order History</a>");
             
            }
        else
            {
        	out.println("<a href=\"\\onlineportal\\home\\loginPage\" >Login</a>");
            }
            %>
	
	<div align="center">
		<h2>List of Products</h2>


		<form action="/onlineportal/shoppingcart/order" method="POST"
			name="form1" id="form1">
			<input type="hidden" name="code" id="code" value="" />
			<table border="1" cellpadding="5">

				<tr>
					<th>Code</th>
					<!-- <th>Product Image</th> -->
					<th>Product Name</th>
					<th>Price</th>
					<th></th>
				</tr>

				<c:forEach items="${listProducts}" var="product">

					<tr>

						<td>${product.code}</td>
						<%-- <td>${product.image}</td> --%>
						<td>${product.name }</td>
						<td>${product.price}</td>
						<td><input type="submit" value="Add to Cart" name="button"
							onclick="fun(${product.code})" /></td>
					</tr>

				</c:forEach>

			</table>

		</form>
		<form action="/onlineportal/shoppingcart/cart" method="POST">
			<input type="submit" value="Check Cart" name="button1">
		</form>

	</div>

</body>
</html>