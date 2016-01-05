<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<title>Agrochum</title>
<link rel="stylesheet" type="text/css" href="registration.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script type="text/javascript">
/*  var selectpost = $('input[name=radioName]:checked', '#showPosts').val();
 alert("post Id"+selectpost);
 */
 function myFunction() {
	    var post_id = document.getElementById("select_radio").value;
	  
	}

</script>
</head>
<body bgcolor="white">
	<header>
		<table align="center" bgcolor="green" border="0" cellpadding="0"
			cellspacing="0" width="100%">
			<tr>
				<td>
					<img align="left" class="image" src="logo.jpg" width="50px" height="50px"><strong>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <font color="green" size="3">&nbsp;<a class="navwhite" href="main.html"><font color="#ffffff">Home</font> </a><font color="#ffffff">&nbsp; |&nbsp; </font><a class="navwhite" href="about.html"><font color="#ffffff">About&nbsp; </font></a><font color="#ffffff">&nbsp; |&nbsp;</font><font><a  class="navwhite" href="logout.jsp"><font color="#ffffff">Logout</font></a></font></strong>
				</td>
			</tr>
			</header>
		</table>
		<div id="main">
			<img class="agrochum" src="leafz.jpg" width="1350px" height="200px"
				top="10">
				<h3 align="center">
				<font face="Book Antiqua" size="72" color="green">Buy Item</font>
			</h3>
		<!-- 	<h1 align="center">
				<font face="Book Antiqua" size="72" color="green">Agrochum
					Registration</font>
			</h1>
		 --></div>
	</header>
</body>
<br />
<body>
	<form id="but_form" action="BuyController" method="post">
		<div class="row">
			<label for="Search Category:">Search</label>
			<!-- <div class="col-sm-2"> -->
				<select id="select_cat_id" name="select_category" with="100%">
					<option value="0">Select Category</option>
					<c_rt:forEach items="${categoryList}" var="category"
						varStatus="status">

						<option id="optval" value="${category.getCategoryId()}">${category.getCategoryName()}</option>
					</c_rt:forEach>
				</select>
				<!-- <div id="statusDisplay"></div> -->

				<!-- </div> -->
				<!-- &nbsp;&nbsp;&nbsp;&nbsp;
		<div class="row">
		 -->
				<input type="submit" style="color: blue" value="Select" id="selectCategory" maxlength="50">
			<!-- </div> -->
		</div>
	</form>

	<br />
	<form action="DisplayBuyDetailsController" id="showPosts">
		<table border="1" cellpadding="5" id="show_results" width="100%">
			<tr>
				<th>Select to Buy</th>
				<th> Post Title</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Image</th>
				<th>Post Date</th>
				<!--<th>Available Date</th> -->
				
			</tr>
			<c_rt:forEach var="buyItem" items="${postItemsList}"
				varStatus="status">
				<tr align="center">
					<td><input type="radio" name="radioName" id="select_radio" value="${buyItem.getPostId()}"></td>
					<td>${buyItem.getTitle()}</td>
					<td>${buyItem.getQuantity()}</td>
					<td>${buyItem.getTotalprice()}</td>
					<td width="400px"><a
						href="<c_rt:out value="${pageContext.servletContext.contextPath }/PhotoServlet?id=${buyItem.getPostId()}"/>"><img
							src="${pageContext.servletContext.contextPath }/PhotoServlet?id=${buyItem.getPostId()}"
							width="25%" height="25%"></a></td>
							<td>${buyItem.getPostDate()}</td>
					<%-- <td><img alt="Img not Loading" src="<c_rt:out value="${pageContext.servletContext.contextPath }/PhotoServlet?id=${buyItem.getPostId()}"/>"></td> --%>
					<%-- <td>${room.rate}</td> --%>
					<%-- <td>${room.availableDate}</td> --%>
					<%-- <td><img src="${buyItem.getImage()}"></td> --%>
					<%-- <c_rt:out value="${pageContext.servletContext.contextPath }/PhotoServlet?id=${buyItem.getPostId()}"/> --%>


				</tr>

			</c_rt:forEach>

		</table>
		<br/>
	<div align="right" draggable="false">	<input style="color: blue" type="submit" value="Buy Item" width="100%" onsubmit="myFunction()"></div>
	</form>

</body>
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
</html>