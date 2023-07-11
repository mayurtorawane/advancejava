<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <ol>    
   <c:forEach var="comm" items="${comments}">
   <li>${comm.cname}</li>
   </c:forEach>
   </ol>
   
   <a href="login.jsp">Add Comments</a>
</body>
</html>