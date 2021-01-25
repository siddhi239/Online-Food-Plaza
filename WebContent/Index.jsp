<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Food Plaza</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	
	<div id="templatemo_container">
		<jsp:include page="Header.jsp"></jsp:include>
		<div align="center">
			<%String msg=(String)request.getAttribute("success");
		if(msg!=null)
		out.print(msg);
		%>
		</div>
		<div id="templatemo_top_dishes">

			<h1>Recommended Dishes</h1>
			<div class="top_dishes_box">
				<img src="images/lasagna.jpg" alt="image" width="205"
					height="150" />
				<h2>Lasagna</h2>
				<p>
					Delicious lasagna served with the complimentary garlic bread.
				</p>
			</div>

			<div class="top_dishes_box">
				<img src="images/templatemo_image_02.jpg" alt="image" />
				<h2>Butter chicken roll</h2>
				
			</div>

			<div class="top_dishes_box">
				<img src="images/templatemo_image_03.jpg" alt="image" />
				<h2>Spanich soup </h2>
				
			</div>

			<div class="top_dishes_box">
				<img src="images/templatemo_image_04.jpg" alt="image" />
				<h2>Meat stew with carrots, potatoes, onions</h2>
				
			</div>

			<div class="cleaner">&nbsp;</div>

		</div>
		<!-- end of top dishes -->

		<div id="templatemo_content">
			<span class="top"></span>
			<div id="templatemo_innter_content">

				<div id="templatemo_content_left">
					<h1>Welcome to our website</h1>
					<img src="images/templatemo_image_05.jpg" alt="image" width="300"
						height="200" />

					<p>...</p>
					<p>...</p>
				

					<div class="cleaner_with_height">&nbsp;</div>

				</div>
				<!-- end of content left -->

				<div id="templatemo_content_right">
					<h1>What's new?</h1>
					<div class="right_column_section">
						<h2>Special meal for you</h2>
						<img src="images/templatemo_image_06.jpg" alt="image" />
						<p>This is the special dish of our restaurant.</p>
						<a href="#">Read more...</a>
					</div>

				</div>
				<!-- end of content right -->
				<div class="cleaner">&nbsp;</div>
			</div>
			<div class="cleaner" style="background: #fff;">&nbsp;</div>
		</div>

		<jsp:include page="Footer.jsp"></jsp:include>


	</div>

	 

</body>
</html>