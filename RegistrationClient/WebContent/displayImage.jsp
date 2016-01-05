<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sql:setDataSource var="webappDataSource"
    driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/test"
    user="root" password="sarasu10" />

<sql:query dataSource="${webappDataSource}"
    sql="select * from postitems" var="result" />

<table width="100%" border="1">
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td>${row.POST_ID}</td>
            <td>${row.POST_NAME}</td>
            <td>
               <img src="${pageContext.servletContext.contextPath }/PhotoServlet?id=${row.POST_ID}" />
            </td>
        </tr>
    </c:forEach>
</table>

