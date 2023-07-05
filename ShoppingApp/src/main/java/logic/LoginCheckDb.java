package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logincheckdb")
public class LoginCheckDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con;
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		con=(Connection)config.getServletContext().getAttribute("jdbccon");
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out=response.getWriter();
		
		String uid=request.getParameter("uid");
		String pass=request.getParameter("pass");
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try
		{
			ps=con.prepareStatement("select * from users where u_id=? and password=?");
			
			ps.setString(1, uid);
			ps.setString(2,pass);
			
			rs=ps.executeQuery();
			if(rs.next())
			{
			if(rs.getString(1).equals(uid) && rs.getString(2).equals(pass))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/home");
				rd.forward(request, response);
				//out.println("sjbdjs");
			}
			}
			else
			{
				//response.sendRedirect("Login.html");
				out.println("fail");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	

}
