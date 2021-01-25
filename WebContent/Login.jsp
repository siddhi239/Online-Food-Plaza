<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<script type="text/javascript">
function validation()
{
	var l= document.getElementById("loginid").value;
	if(l == "")
		{
		document.getElementById("lerror").innerHTML="Please enter the Login Id";
		return false;
		}
	
	var p = document.getElementById("pid").value;
	if(p == "")
		{
		document.getElementById("perror").innerHTML="Please enter the Password";
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
span {
	color: red;
}
</style>
</head>
<body>
<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>
<div align="center">
<form action="LoginServlet" method="post">
	<h1>LOGIN</h1>
	Type:
	<select name="typename" >
		<option value="Admin">Admin</option>
		<option value="Customer">Customer</option>
	</select>
	<br>
	<br> 
	Login Id:<input type="text" name="lid" id="loginid" ><span id="lerror">*</span>
	<br>
	<br> 
	Password:<input type="password" name="pwd" id="pid" onkeyup="clearup(this)"> <span id="perror">*</span>
	<br>
	<br>
	<input type="submit" value="Login" onclick="return validation()">
	<input type="reset" value="Clear">
</form>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>