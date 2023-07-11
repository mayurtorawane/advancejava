<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<%
  Connection con=(Connection)application.getAttribute("jdbccon");

    PreparedStatement ps=null;
    ResultSet rs=null; 
    
    try
	{
	   ps=con.prepareStatement("select * from product where cat_id=?");
	   String cid=request.getParameter("cid");
	   ps.setString(1, cid);
	   rs=ps.executeQuery();%>
	   <form action="addtocard" method="get">
	   <select name="category">
	   <% while(rs.next())
		   { %>
		<option value=<%=rs.getInt(1) %>><%= rs.getString(2)%></option> 
		  <% }%>
	   </select>
	   <input type='submit' value='Add To Cart' />
	   </form>
    <%  }
     catch(Exception e)
    {
    	 e.printStackTrace();
    }
    %>
	   

</body>
</html>