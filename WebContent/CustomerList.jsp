<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@page import="java.util.*,POJO.*" %>
<body>

<%List<Customer> cl=(List<Customer>)session.getAttribute("clist"); %>
<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>
<div align="center">
<h1>CUSTOMER DETAILS</h1>
<table border=1>
<tr>
<th>Customer Name</th>
<th>Customer Email</th>
<th>Contact</th>
<th>Address</th>
</tr>

<%for(Customer c:cl){%>
<tr>
<td><%=c.getName() %></td>
<td><%=c.getEmail()%></td>
<td><%=c.getContact() %></td>
<td><%=c.getAddress() %></td>
<td> <a href="CommonCustomerServlet?action=editcustomer&cid=<%=c.getId() %>">Edit</a></td>
<td> <a href="CommonCustomerServlet?action=delete&cid=<%=c.getId() %>">Delete</a></td>
</tr>
<%} %>
</table>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>