<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<title>sell Info</title>
<link rel="stylesheet" type="text/css" href="login.css">
<!-- <script>
	$(document).ready(function() {
		$("#select_cat_id").change(function() {
			var thisvalue = $(this)[0].selectedIndex;

			//   var emailValue = $("#email").val();
			$.post("PostDetails", {
				method : "selectCategory",
				categoryid : thisvalue

			}, function(data) {

				document.getElementById("select_sub_cat_id").innerHTML = data;
			});
		});
	});
</script>
 -->

</head>
<head>

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
			</table><br/>
			





<br />
<form action="PostDetails" method="get">

	<!-- <fieldset>
		<legend>Posting Details:</legend>
	 -->	<table align="center" width="750">
			<tbody>
				<tr>
					<td>


						<table>


							<tbody>
								<tr  height="30px">

									<td><label>Title:</label></td>

									<td><input name="title" type="text"></td>


								</tr>


								<!-- <tr>

									<td><label>Name :</label></td>

									<td><input name="postname" type="text"></td>



								</tr>
 


								<tr>

									<td><label>Email Address :</label></td>

									<td><input name="ea" type="text"></td>

								</tr>
-->

								<tr  height="30px">

									<td><label>Business Name :</label></td>

									<td><input name="businessName" type="text"></td>



								</tr>

								<tr  height="30px">

									<td><label>Phone Number :</label></td>

									<td><input name="contact_num" type="text"></td>



								</tr>

							</tbody>
						</table>
					</td>

					<td>

						<table>
							<tbody>
								<tr>

									<th colspan="2"><b><font color="green" size="5">Address</font></b></th>

								</tr>

								<tr  height="30px">

									<td><label>Address Line1 :</label></td>

									<td><input name="addr1" type="text"></td>
								</tr>




								<tr height="30px">

									<td><label>Address Line2 :</label></td>

									<td><input name="addr2" type="text"></td>
								</tr>




								<tr height="30px">

									<td><label>City :</label></td>

									<td><input name="city" type="text"></td>




								</tr>





								<tr height="30px">

									<td><label>State :</label></td>

									<td><input name="state" type="text"></td>




								</tr>




								<tr height="30px">

									<td><label>ZipCode :</label></td>

									<td><input name="zipcode" type="text"></td>
								</tr>


								<tr height="30px">
									<td><label>Country :</label></td>

									<td><input name="country" type="text"></td>


								</tr>
							</tbody>
						</table>


					</td>
				</tr>
			</tbody>
		</table>


<p align="center"><input type="image" src="next.png" alt="submit" width="90" height="50"></p>


		<!-- <p align="right">




			<button type="submit">
				<h2>
					<b>NEXT</b>
				</h2>
			</button>





		</p>
 -->

<!-- 	</fieldset> -->

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
</html>



