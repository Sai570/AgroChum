<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<title>Sell Info</title>

<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>

<script>
	$(document).ready(function() {
		$("#select_cat_id").change(function() {
			var thisvalue = $(this)[0].selectedIndex;

			//   var emailValue = $("#email").val();
			$.post("PostDetails", {
				method : "selectCategory",
				categoryid : thisvalue

			}, function(data) {
				/*  obj = JSON.parse(data);
				 if(obj.status=='available'){
				 document.getElementById("statusDisplay").style.color = "green";
				 }else if(obj.status=='Not available'){
				   document.getElementById("statusDisplay").style.color = "red";
				 } */

				document.getElementById("select_sub_cat_id").innerHTML = data;
			});
		});
	});
</script>

</head>

<body bgcolor="white">

    <header>
        <table bgcolor="green" border="0" cellpadding="2" cellspacing="2" width="1355px" height="10px">
   <tr>
<td>
  
<img align="left" class="image" src="logo.jpg" width="50px" height="50px"><strong>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <font color="green" size="3">&nbsp;<a class="navwhite" href="main.html"><font color="#ffffff">Home</font> </a><font color="#ffffff">&nbsp; |&nbsp; </font><a class="navwhite" href="about.html"><font color="#ffffff">About&nbsp; </font></a><font color="#ffffff">&nbsp; |&nbsp;</font><font><a  class="navwhite" href="logout.jsp"><font color="#ffffff">Logout</font></a></font></strong>
            </td>
        </tr>
       
    </table>
    <div id="main">
        <img class="Header" src="leafz.jpg" width="1355px" height="200px" top="10"><h1
            align="center">
            <font face="Book Antiqua" size="72" color="green"></font></h1>
    </div> </header>
<p align="center"><font face="Book Antiqua" size="72" color="green">Sell Information</font></h1></div>
		            </body>
	</tbody>
	<br />

<%
	String title = request.getParameter("title");
	session.setAttribute("title", title);
/* 	String postname = request.getParameter("postname");
	session.setAttribute("postname", postname);
 */	String businessName = request.getParameter("businessName");
	session.setAttribute("businessName", businessName);
	String contact_num = request.getParameter("contact_num");
	session.setAttribute("contact_num", contact_num);
	String addr1 = request.getParameter("addr1");
	session.setAttribute("addr1", addr1);
	String addr2 = request.getParameter("addr2");
	session.setAttribute("addr2", addr2);
	 String city = request.getParameter("city");
	session.setAttribute("city", city);
	 String state = request.getParameter("state");
	session.setAttribute("state", state);

	String zipcode = request.getParameter("zipcode");
	session.setAttribute("zipcode", zipcode);
	String country = request.getParameter("country");
	session.setAttribute("country", country);
	
	%>







<form action="PostController" ENCTYPE="multipart/form-data"
	method="post">
	<div clas="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-2">
			<label>Sell Categories :</label>
		</div>
	</div>
	

	<div class="col-sm-2">
		<select id="select_cat_id" name="select_category">
			<option value="0">Select Category</option>
			<c_rt:forEach items="${categoryList}" var="category"
				varStatus="status">

				<option id="optval" value="${category.getCategoryId()}">${category.getCategoryName()}</option>
			</c_rt:forEach>
		</select>
		<!-- <div id="statusDisplay"></div> -->
	</div>
	<div class="col-sm-2">
		<label>Choose subCategory:</label>
	</div>
	<select id="select_sub_cat_id" name="select_sub_category">
		<option value="0" value="Select Items">Select Items</option>
	</select>

	</div>
	<br />
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-2"></div>

	</div>



	<br />



	<div clas="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-2">

			<label>Description:</label>
		</div>

		<div class="col-sm-2">

			<input type="text" name="description" />
		</div>



	</div>




	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-2"></div>

	</div>

	<br />
<div clas="row">
		<div class="col-sm-3"></div>

		<div class="col-sm-2">

			<label>Quantity:</label>
		</div>


		<div class="col-sm-2">
			<input type="text" name="quantity" placeholder="Enter quantity per unit/lb" />

		</div>
	</div>

<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-2"></div>

	</div>

<br/>
	<div clas="row">
		<div class="col-sm-3"></div>

		<div class="col-sm-2">

			<label>Price:</label>
		</div>


		<div class="col-sm-2">
			<input type="text" name="price" placeholder="Price per unit/lb" />

		</div>
	</div>


	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-2"></div>

	</div>

	<br>
	<div clas="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-2">

			<label>Upload Image:</label>
		</div>
		<div class="col-sm-2">

			<input type="file" name="image" accept="image/*">
		</div>

	</div>

	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-2"></div>

	</div>
	<br>

	<div clas="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-2">


			<div class="col-sm-2">

				<input align="right" style="color: blue" type="submit" value="Post">
			</div>

		</div>
</form>
</body>

<p>
	<strong><strong>&nbsp;</strong></strong>
</p>
<table align="center" bgcolor="green" border="0" cellpadding="0"
	cellspacing="0" width="100%">
	<footer>
	<tr>
		<td>
			<p align="center">
				<strong><font color="green" size="3">&nbsp;<a
						class="navwhite" href="www.fb.com"><font color="#ffffff">Facebook</font>
					</a><font color="#ffffff">&nbsp; |&nbsp; </font><a class="navwhite"
						href="changethis.htm"><font color="#ffffff">Contact Us
								&nbsp; </font></strong>
			</p>
		</td>
	</tr>
	</footer>
</table>
<p align="center">
	<font size="1"><font size="1"><font size="1"><font
				size="1"><font size="1">&copy Copyright 2015,Agrochum</font><font
					size="1">&nbsp; </font></font></font></font></font>
</p>
</body>
</html>