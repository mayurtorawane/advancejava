<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
   <c:forEach var="topic" items="${topics}">
   <a href="getComment?tid=${topic.tid}">${topic.tname}</a>
   <br>
   </c:forEach>
   <br>
   <br>
   <a href="login.jsp">Add Topic</a>
   
</body>
</html>