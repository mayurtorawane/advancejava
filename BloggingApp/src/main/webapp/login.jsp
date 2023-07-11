<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action="http://localhost:8080/BloggingApp/logincheckdb" method="post">
    Enter uid:<input type="text" name="uid">
   <br>
   Enter password:<input type="password" name="pass">
   <br>
   <input type="submit" value="Login">
   <input type="reset" value="Clear">
 </form>

</body>
</html>