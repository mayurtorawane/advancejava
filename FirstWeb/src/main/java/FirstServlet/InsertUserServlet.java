package FirstServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InsertUserServlet")
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	Connection con;
	@Override
	public void init(ServletConfig config) throws ServletException {
	
		super.init(config);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbc="jdbc:mysql://localhost:3306/shoppingdb";
			
			con=DriverManager.getConnection(jdbc,"root","root");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String uid=request.getParameter("uid");
		String pass=request.getParameter("pass");
		String fname=request.getParameter("fname");
		String mname=request.getParameter("mname");
		String lname=request.getParameter("lname");
		String mail=request.getParameter("email");
		String contact=request.getParameter("contact");
		
		PreparedStatement ps=null;
		int n=0;
		try
		{
			ps=con.prepareStatement("insert into users values(?,?,?,?,?,?,?)");
			
			ps.setString(1, uid);
			ps.setString(2, pass);
			ps.setString(3, fname);
			ps.setString(4, mname);
			ps.setString(5, lname);
			ps.setString(6, mail);
			ps.setString(7, contact);
		
			n=ps.executeUpdate();
			if(n>0)
			{
				out.println("data inserted succesfully");
			}
			else
				out.println("data not inserted");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
