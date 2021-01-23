<%@page import="java.util.*,in.coder.foodplaza.pojo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Food</title>


<link href="css_style/food_design.css" rel="stylesheet">
<script type="text/javascript">
function validation()
{
	var name = document.getElementById("nameid").value;
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
	var p = document.getElementById("priceid").value;
	if(p == "")
		{
		document.getElementById("perror").innerHTML="Please enter the Food Price";
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
<h1>UPDATE FOOD</h1>
<%Food f=(Food)session.getAttribute("food"); %>


<form action="CommonFoodServlet" method="post">
FoodId: <input type="text" name="fid" value="<%=f.getFoodid() %>" id="foodid" readonly><br><br>
FoodName: <input type="text" name="myname" value="<%=f.getFoodname() %>" id="nameid" placeholder="Food Name" onkeyup="clearup(this)"><span id="nerror">*</span><br><br>
FoodPrice: <input type="foodprice" name="price" value="<%=f.getFoodprice() %>" id="priceid" placeholder="Food Price"onkeyup="clearup(this)"><span id="perror">*</span><br><br>
FoodType:
<select name="myfoodtype" value="<%=f.getFoodtype() %>">
<option value="Veg">Veg</option>
<option value="Non-Veg">Non-Veg</option> 
</select>
<br><br>
<input type="hidden" name="action" value="updatefood">
<input type="submit" value="Add" onclick="return validation()">
<input type="reset" value="Clear">
</form>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>