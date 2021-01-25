<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@page import="java.util.*,POJO.*"%>
<body>
<div align="center">
			<%String msg=(String)request.getAttribute("fail");
		if(msg!=null)
		out.print(msg);
		%>
</div>
	<%
		List<Food> fl = (List<Food>) session.getAttribute("flist");
	String aemail=(String)session.getAttribute("adminid");
	String cemail=(String)session.getAttribute("custid");
	%>
	<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>
<div align="center">
	<h1>FOOD DETAILS</h1>
	<table border="1">
		<tr>
			<th>Food Id</th>
			<th>Food Name</th>
			<th>Food Price</th>
			<th>Food Type</th>
			
		</tr>
		<%
			for (Food f : fl) {
		%>
		<tr>
			<td><%=f.getFoodid()%></td>
			<td><%=f.getFoodname()%></td>
			<td><%=f.getFoodprice()%></td>
			<td><%=f.getFoodtype()%></td>
		
		<% if(aemail!= null && cemail == null){%>
		
		<td> <a href="CommonFoodServlet?action=editfood&fid=<%=f.getFoodid() %>">Edit</a></td>
		<td> <a href="CommonFoodServlet?action=delete&fid=<%=f.getFoodid() %>">Delete</a></td>
		<%} %>
		<%if(aemail== null && cemail != null){ %>
		<td> <a href="CommonOrdertServlet?action=addtocart&fid=<%=f.getFoodid() %>">Add To Cart</a> </td>
		<%} %>
		</tr>
		<%} %>
	</table>
	</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>