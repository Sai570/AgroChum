<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

 <script type="text/javascript">
$(document).ready(function(){
   
 //  var loc =  document.getElementById('loc_id').value;
var loc = $("#loc_id").val();
 document.getElementById('iframe').src = "https://www.google.com/maps/embed/v1/place?q=" +loc+"&&key=AIzaSyAN0om9mFmy1QN6Wf54tXAowK4eT0ZUPrU";
   
});

</script> 


 <style>
 #section1 {
    width:200px;
    float:right;
    height:300px;	 	 
} 
/* iframe {
    float: right;
    height: 250px;
    padding: 50px;
    width: 250px;
}
 */
 #section2 {
    width:200px;
    float:left;
     height:300px;
    	 	 
}
 
</style>


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
<p align="center"><font face="Book Antiqua" size="72" color="green">Agrochum Buy Product</font></h1></div>
		            </body>
	</tbody>
			</table><br/>
			
			
			
<input id="loc_id" type="hidden" value='<c_rt:out value="${address}"/>'>
<form action="payement_details.jsp">
<div id="section2" align="justify">
<table>
<c_rt:forEach items="${postDetailsList }" var="postDetails" varStatus="status">


<tr><td><img src="${pageContext.servletContext.contextPath }/PhotoServlet?id=${postDetails.getPostId()}"
							width="150%" height="30%"> </td> </tr>
<tr><td>Business Name:</td><td></td>
<td>${postDetails.getBusinessName()}</td></tr>							
<tr><td>Price:</td><td></td>
<td>$<c_rt:out value="${postDetails.getTotalprice()}"></c_rt:out></td></tr>
<tr><td>Quantity:</td><td></td>
<td>${postDetails.getQuantity()}</td></tr>
<tr><td>Total Price:</td>
<td><c_rt:set value="${postDetails.getTotalprice() * postDetails.getQuantity() }" var="totalPrice"></c_rt:set> </td>
<td>$<c_rt:out value="${totalPrice }"></c_rt:out></td>
<tr><td></td></tr>


</c_rt:forEach>
</table>
<div align="left"><input type="submit" style="color: blue" value="Proceed to CheckOut" ></div>
</div>


</form>
<div id="section1" align="justify">
<iframe  id = "iframe" frameborder="0" src="" marginheight="400px" height="350px" width="350px" marginwidth="400px" align="right"></iframe>
</div>
			
			
			
			
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

                        <p><strong><strong>&nbsp;</strong></strong></p>
<table align="left" bgcolor="green" border="0" cellpadding="0" cellspacing="0" width="100%">
<footer>
<tr>
<td>
    <p align="center"><strong><font color="green" size="3">&nbsp;<a class="navwhite" href="www.fb.com"><font color="#ffffff">Facebook</font> </a><font color="#ffffff">&nbsp; |&nbsp; </font><a class="navwhite" href="changethis.htm"><font color="#ffffff">Contact Us &nbsp; </font></strong></p>
           <p align="center" ><font size="1"><font size="1"><font size="1"><font size="1"><font size="1"> &copy Copyright 2015,Agrochum</font><font size="1">&nbsp; </font></font></font></font></font></p>
            </td>
        </tr>
    
</table><br/><br/><br/>
<!-- <span align="bottom"><font size="1"><font size="1"><font size="1"><font size="1"><font size="1"> &copy Copyright 2015,Agrochum</font><font size="1">&nbsp; </font></font></font></font></font></span> -->

</html>






