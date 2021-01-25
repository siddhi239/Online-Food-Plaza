
<%@page import="POJO.Food"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart Details</title>
</head>
<%@page import="java.util.*,POJO.*"%>
<body>
	<%
		List<Cart> cl = (List<Cart>) session.getAttribute("clist");
		
	%>
<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>
<form action="CommonOrdertServlet" method="post">
<div align="center">
	<% String msg=(String)request.getAttribute("msg");%>
	<%=msg %>
	<h1>Cart Details</h1>
	<table border=1>
		<tr>
			<th>Food Name</th>
			<th>Food Price</th>
			<th>Food Quantity</th>
		</tr>
		<%
			for (Cart c: cl) {
		%>
		<tr>
			<td><%=c.getFoodname() %></td>
			<td><%=c.getFoodprice() %></td>
			<input type="hidden" name="foodprice" value="<%=c.getFoodprice()%>">
			<td><input type="number" name="foodquantity" value=<%=c.getFoodquantity()%> min='1'></td>
				
		<td> <a href="CommonOrdertServlet?action=deleteCart&cid=<%=c.getCartid() %>">Delete</a></td>
	</tr>
	<%} %>	
	
	</table>
	<input type="submit" value="PlaceOrder">
	</form>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</div>

</body>
</html>