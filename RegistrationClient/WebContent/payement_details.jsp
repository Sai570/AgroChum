<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Mode</title>
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
<p align="center"><font face="Book Antiqua" size="72" color="green">Payment Details</font></h1></div>
		            </body>
	</tbody>
			</table><br/>
			
			

<img  alt="Image Not Loading" src="payment_images.jpg">
<c_rt:if test="${not empty message}">
    <h2 align="center" style="color: green">${message}</h2>
</c_rt:if>



<form action ="PaymentServlet" method="post">
<div align="center"  class="step" data-step-title="Payment">
            <div class="control-group">
                <label class="control-label" for="CardHolderName">Card Holder Name</label>
                    <div class="controls">
                    <input type="text" name ="CardHolderName" id="CardHolderName" placeholder="Name" class="input-xlarge">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="CreditCardNumber">Credit Card Number</label>
                    <div class="controls">
                    <input type="text" id="CreditCardNumber" name ="CreditCardNumber" placeholder="16 digit Number" class="input-xlarge" maxlength="16">
                </div>
            </div>
             <div class="control-group">
                <label class="control-label" for="ExpiryDate">Expiry Date</label>
                    <div class="controls">
                    <input type="text" id="ExpiryDate" name ="ExpiryDate" placeholder="format MM/YYYY" class="input-xlarge">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="CVV">CVV</label>
                    <div class="controls">
                    <input type="text" id="CVV" name="CVV" placeholder="CVV" maxlength="3" class="input-xlarge">
                </div>
            </div>
             
        </div>
<br/>
 <div align="center">   <input type="submit" value="Pay Now"></div>
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



