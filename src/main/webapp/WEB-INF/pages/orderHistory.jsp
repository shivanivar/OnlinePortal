<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.ecom.springmvc.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order History</title>
</head>
<body>
<%
        User user =  (User)session.getAttribute("user");
        if(user !=null)
            {
             out.println("<a href=\"\\onlineportal\\home\\logout\" >Logout</a>");
             out.println("                 ");
             out.println("<a href=\"\\onlineportal\\products\\product\" >Buy Product</a>");
             
            }
        else
            {
        	out.println("<a href=\"\\onlineportal\\home\\loginPage\" >Login</a>");
            }
            %>
	
	<div align="center">
		<h2>List of Products</h2>


		<form action="" method="POST" name="form1" id="form1">
			<input type="hidden" name="code" id="code" value="" />
			<table border="1" cellpadding="5">
				<tr>

					<th width="60">Order no</th>
					<th width="60">Product Name</th>
					<th width="60">Product Price</th>
					<th width="60">Product Quantity</th>
					<th width="60">Total Amount</th>

				</tr>

				<c:forEach items="${listOrder_details}" var="listOrderDetails"
					varStatus="i">
					<c:set var="count" value="${i.count}" scope="page" />

					<tr>
						<td colspan="2"> Order Number : ${i.count}</td>

						<td>
							

								<c:forEach items="${listOrderDetails}" var="order">
								
									<tr>
										<td></td>										
										<td>${order.product_code.name }</td>
										<td>${order.price}</td>
										<td>${order.quanity}</td>
										<td>${order.order_id.amount}</td>
									</tr>
								
								</c:forEach>
								
							
						</td>

					</tr>




				</c:forEach>

			</table>

		</form>
	</div>
</body>
</html>