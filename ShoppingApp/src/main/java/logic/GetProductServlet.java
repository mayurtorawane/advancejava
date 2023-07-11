package logic;

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


@WebServlet("/getproduct")
public class GetProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    Connection con;
	@Override
	public void init(ServletConfig config) throws ServletException {
		con=(Connection)config.getServletContext().getAttribute("jdbccon");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try
		{
		   ps=con.prepareStatement("select * from product where cat_id=?");
		   String cid=request.getParameter("cid");
		   ps.setString(1, cid);
		   rs=ps.executeQuery();
		   out.print("<form action='addtocard' method='get'>");
		   out.print("<select name='category'>");
		   while(rs.next())
		   {
			   out.println("<option value="+rs.getInt(1)+">"+rs.getString(2)+"</option>");
		   }
		   out.print("</select>");
		   out.print("<br/> <input type='submit' value='Add To Cart' />");
		   out.print("</form>");
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
