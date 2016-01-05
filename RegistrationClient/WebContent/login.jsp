<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agrochum</title>
<link rel="stylesheet" type="text/css" href="login.css">
<!-- <style>
a { color: inherit; } 
html { overflow-y: hidden; }
</style>
 --></head>
<body bgcolor="white">
	<header>
	<table align="center" bgcolor="green" border="0" cellpadding="0"
		cellspacing="0" width="100%">
		<tr>
			<td>
				<p align="center">
					<strong><font color="green" size="3">&nbsp;<a
							class="navwhite" href="main.html"><font color="#ffffff">Home</font>
						</a><font color="#ffffff">&nbsp; |&nbsp; </font><a class="navwhite"
							href="about.html"><font color="#ffffff">About&nbsp; </font></a><font
							color="#ffffff">&nbsp; |&nbsp;</font> <a class="navwhite"
							href="login.html"><font color="#ffffff">Login</font></a> <font
							color="#ffffff">&nbsp; |&nbsp; </font><a class="navwhite"
							href="registration.html"><font color="#ffffff">Registration</font></a></font></strong>
				</p>
			</td>
		</tr>
		</header>
	</table>
	<div id="main">
	
			<img class="agrochum" src="leafz.jpg" width="1350px" height="200px"
				top="10">
		<h1 align="center">
			<font face="Book Antiqua" size="72" color="green">Agrochum
				Login</font>
		</h1>
		
	</div>
</body>
</tbody>
</table>
<br />

<c_rt:if test="${not empty userStatus}">
    <h2 align="center" style="color: green">${userStatus}</h2>
</c_rt:if>


<%-- <center style="color: green"><h2><%=request.getSession().getAttribute("userStatus") %><h2></center> --%>
<form action="LoginClient" method="post">
	<div class="row">
		<label>Email Address<br />
		</label><input type="text" id="name" name="email" maxlength="30" border="1px"
			placeholder="Enter your User Name">
	</div>
	<br />
	<div class="row">
		<label>Password<br />
		</label><input type="password" id="password" name="password" maxlength="10"
			placeholder="Enter your Password">
	</div>
	<br />
	<div class="row">
		<input type="submit" value="Login">
	</div>
</form>

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