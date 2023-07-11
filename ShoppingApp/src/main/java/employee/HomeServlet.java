package employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EmpHomeServlet", urlPatterns = { "/emphome" })
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   Connection con;
	@Override
	public void init(ServletConfig config) throws ServletException {
		con=(Connection)config.getServletContext().getAttribute("jdbccon1");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		Statement ss=null;
		ResultSet rs=null;
		try
		{
			ss=con.createStatement();
			rs=ss.executeQuery("select * from dept");
			while(rs.next())
			{
				out.println("<a href='getEmp?deptno="+rs.getInt(1)+"'>"+rs.getString(2)+"</a> </br>");
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
