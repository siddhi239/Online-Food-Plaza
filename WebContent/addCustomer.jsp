<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer details</title>

<script type="text/javascript">
function validation()
{
	var name = document.getElementById("custname").value;
	if(name == "")
		{
		document.getElementById("nerror").innerHTML="Please enter the Food Name";
		return false;
		}
	if(!isNaN(name))
		{
		document.getElementById("nerror").innerHTML="Please enter only Food Name";
		return false;
		}
	var pwd = document.getElementById("pname").value;
	if(pwd == "")
		{
		document.getElementById("perror").innerHTML="Please enter the password";
		return false;
		}	
	var email1 = document.getElementById("mailid").value;
	if(email1 == "")
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
<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>
<div align="center">
<h1>Customer Details</h1>
<form action="CommonCustomerServlet" method="post">
Customer Name: <input type="text" name="cname" id="custname" onkeyup="clearup(this)"><span id="nerror">*</span><br><br>
Password:<input type="password" name="pname" id="pname"><span id="perror">*</span><br><br>
Customer Email Address: <input type="mail" name="nmail" id="mailid" onkeyup="clearup(this)"><span id="eerror">*</span><br><br>
Contact: <input type="text" name="contact" id="cont"> <br><br>
Address: <textarea rows="4" cols="80" name="myaddr"></textarea><br><br>
<input type="submit" value="Add" onclick="return validation()">
<input type="reset" value="Clear">
</form>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>