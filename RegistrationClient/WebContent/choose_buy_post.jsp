<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Choose Sell / Buy</title>

<head>
<link rel="stylesheet" type="text/css" href="login.css">
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
<p align="center"><font face="Book Antiqua" size="72" color="green">Choose Mode</font></h1></div>
		            </body>
	</tbody>
			</table><br/>
			










<c_rt:if test="${not empty msg}">
    <h2 align="center" style="color: green">${msg}</h2>
</c_rt:if>






		<h1 align="center">
			<p align="center">
				<strong><font color="green" size="3">&nbsp;<a
						class="navwhite" href="mainpost.jsp"><font size="8"
							color="Green"><img src=sell_logo.jpg id="myImgId"
								onmouseover="bigImg(this)" onmouseout="normalImg(this)"
								height="100" width="250" /></font> </a><font color="#ffffff">&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; </font><a class="navwhite"
						href="BuyController"><font size="8" color="green"><img
								src=buy_logo.jpg id="myImgId" onmouseover="bigImg(this)"
								onmouseout="normalImg(this)" height="100" width="250" />&nbsp;
						</font></a><font color="#ffffff">&nbsp; |&nbsp;</font> <font color="#ffffff"></font></font></strong>
			</p>
</body>
</tbody>
</table>
<br />


<br>
<br>
<br>
<br>
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