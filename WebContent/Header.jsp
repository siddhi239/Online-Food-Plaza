<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%String aemail=(String)session.getAttribute("adminid");
	String cemail=(String)session.getAttribute("custid");%>
	<div id="templatemo_header">
		<div id="site_title"></div>
	</div>
	<!-- end of header -->

	<div id="templatemo_menu">
		<ul>
			<li class="current"><a href="#"><b>Home</b></a></li>
			<li><a href="CommonFoodServlet"><b>Food</b></a>
			<%if(aemail==null && cemail==null){ %>
			<li><a href="addCustomer.jsp"><b>Register</b></a>
			<li><a href="Login.jsp"><b>Login</b></a>
			<%}
			if(aemail!=null && cemail==null)
			{
			%>
			<li><a href="addFood.jsp"><b>Add Food</b></a>
			<li><a href="CommonCustomerServlet"><b>Customer List</b></a>
			<li><a href="ChangePassword.jsp"><b>Change Password</b></a>
			<%}
			if(aemail==null && cemail!=null)
			{
			%>
			<!-- <li><a href="editProfile.jsp"><b>Edit Profile</b></a></li> -->
			<li><a href="CommonOrdertServlet"><b>Show Cart</b></a></li>
			<%}
			if(aemail!=null || cemail!=null)
			{%>
			<li><a href="LoginServlet?action=logout"><b>Logout</b></a></li>
			<%} %>
	
		</ul>
	</div>
	<!-- end of menu -->
</body>
</html>