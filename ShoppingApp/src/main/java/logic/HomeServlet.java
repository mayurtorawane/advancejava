package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con;
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		con=(Connection)config.getServletContext().getAttribute("jdbccon");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		RequestDispatcher rd=request.getRequestDispatcher("/header");
		rd.include(request, response);
		
		
		PrintWriter out=response.getWriter();
	   
	   Statement ps=null;
	   ResultSet rs=null;
	   try
	   {
		  ps=con.createStatement();
		  rs=ps.executeQuery("select * from category");
		  while(rs.next())
		  {
			  out.println("<a href='getproduct.jsp?cid="+rs.getInt(1) +"'>"+rs.getString(2)+"</a>");
			  out.print("</br>");
			 
		  }
	   }
	   catch (Exception e) {
		e.printStackTrace();
	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
