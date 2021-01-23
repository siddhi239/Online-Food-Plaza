<%@page import="java.util.*,in.coder.foodplaza.pojo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
function validation()
{
	var name = document.getElementById("custname").value;
	if(name == "")
		{
		document.getElementById("nerror").innerHTML="Please enter the Customer Name";
		return false;
		}
	if(!isNaN(name))
		{
		document.getElementById("nerror").innerHTML="Please enter only Customer Name";
		return false;
		}
	var email = document.getElementById("mailid").value;
	if(email == "")
		{
		document.getElementById("eerror").innerHTML="Please enter the email address";
		return false;
		}	
	
	return true;
}
function clearup(x)
{
	if(x.value!="")
		{
		x.nextElementSibling.innerHTML="*";
		}
	}

</script>
<style type="text/css">
span
{
color:red; 
}
</style>

</head>
<body>

<%Customer c=(Customer)session.getAttribute("customer"); %>
<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>
<div align="center">
<h1>Customer Details</h1>
<form action="CommonCustomerServlet" method="post">
Customer Id:  <input type="text" name="cid" value="<%=c.getId() %>" id="custid" readonly> <br><br>
Customer Name: <input type="text" name="cname" value="<%=c.getName() %>" id="custname" onkeyup="clearup(this)"><span id="nerror">*</span><br><br>
Password:<input type="password" name="pname" value="<%=c.getPassword()%>" id="pname"><br><br>
Customer Email Address: <input type="mail" name="nmail" value="<%=c.getEmail() %>" id="mailid" onkeyup="clearup(this)"><span id="eerror">*</span><br><br>
Contact: <input type="text" name="contact" value="<%=c.getContact() %>" id="cont"> <br><br>
Address: <textarea rows="4" cols="80" name="myaddr" ><%=c.getAddress() %></textarea><br><br>
<input type="hidden" name="action" value="updatecustomer">
<input type="submit" value="Add" onclick="return validation()">
<input type="reset" value="Clear">
</form>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>