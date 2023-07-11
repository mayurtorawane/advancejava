<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <%
   SimpleDateFormat dt=new SimpleDateFormat("HH");
   
  String hour=dt.format(Calendar.getInstance().getTime());
  
  int hh=Integer.parseInt(hour);
  
  if(hh < 12)
  {%>
	<%= "<h1>Good morning </h1>" %> 
 <%  }
  else if(hh>=12 && hh<= 16)
  {%>
	<%= "<h1>Good aftennoon </h1>" %> 
	  
 <%  }
  else if(hh>=16 && hh<=21)
  {%>
	<%= "<h1>Good aftennoon </h1>" %> 
	  
  <%}
  else
  {%>
	<%= "<h1>Good night </h1>" %> 
  <% }
   %>
</body>
</html>