<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.ecom.springmvc.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order successful</title>
</head>
<body>
	<%
        User user =  (User)session.getAttribute("user");
        if(user !=null)
            {
             out.println("<a href=\"\\onlineportal\\home\\logout\" >Logout</a>");
             out.println("                 ");
             out.println("<a href=\"\\onlineportal\\products\\product\" >Buy More</a>");
             out.println("                 ");
             out.println("<a href=\"\\onlineportal\\orders\\orderhistory\" >Order History</a>");
            }
        else
            {
        	out.println("<a href=\"\\onlineportal\\home\\loginPage\" >Login</a>");
            }
            %>

	<h3>Order successfully Placed</h3>
</body>
</html>