package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Comments;


@WebServlet("/getComment")
public class GetCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		con=(Connection)config.getServletContext().getAttribute("jdbccondb");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		int cid=Integer.parseInt(request.getParameter("tid"));
		try
		{
			
			ps=con.prepareStatement("select * from comments where topicid=?");
			ps.setInt(1, cid);
			rs=ps.executeQuery();
			
		    List<Comments> comments=new ArrayList<>();
		    while(rs.next())
		    {
		    	Comments ct=new Comments(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4) );
		    	comments.add(ct);
		    }
		    getServletContext().setAttribute("comments", comments);
		    
		    RequestDispatcher rd=request.getRequestDispatcher("/comment.jsp");
		    rd.forward(request, response);
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
