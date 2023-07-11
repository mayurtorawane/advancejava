<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
  <jsp:useBean id="user" class="bean.User" scope="request"/>
  <jsp:setProperty property="*" name="user"/>
  <jsp:forward page="/displayBean.jsp"/>
</body>
</html>