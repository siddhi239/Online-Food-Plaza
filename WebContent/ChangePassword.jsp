<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
<script type="text/javascript">
function validation()
{
	var l= document.getElementById("loginid").value;
	if(l == "")
		{
		document.getElementById("lerror").innerHTML="Please enter the Login Id";
		return false;
		}
	var p = document.getElementById("oldpwd").value;
	if(p == "")
		{
		document.getElementById("operror").innerHTML="Please enter the Password";
		return false;
		}	
	var p1 = document.getElementById("newpwd").value;
	if(p1 == "")
		{
		document.getElementById("nperror").innerHTML="Please enter the Password";
		return false;
		}	
	var p2 = document.getElementById("conpwd").value;
	if(p2 == "")
		{
		document.getElementById("cperror").innerHTML="Please enter the Password";
		return false;
		}	
	if(p1!=p2)
		{
		document.getElementById("perror").innerHTML="The new and confirmed password must be same";
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
<h1>CHANGE PASSWORD</h1>
<form action="LoginServlet" method="post">
Login Id: <input type="text" name="lid" id="loginid"><span id="lerror">*</span><br><br>
Old Password: <input type="password" name="opid" id="oldpwd" onkeyup="clearup(this)"> <span id="operror">*</span><br><br>
New Password: <input type="password" name="npid" id="newpwd" onkeyup="clearup(this)"><span id="nperror">*</span><br><br>
Confirm Password: <input type="password" name="cpid" id="conpwd" onkeyup="clearup(this)"><span id="cperror">*</span><br><br>
<input type="hidden" name="action" value="chngepwd"><span id="perror"></span>
<input type="submit" value="Change Password" onclick="return validation()">
<input type="Reset" value="Clear">
</form>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>