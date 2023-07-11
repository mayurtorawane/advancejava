package statemanagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/visitcount")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n=0;
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Cookie [] allc=request.getCookies();
		if(allc !=null)
		{
			for(Cookie c:allc)
			{
				if(c.getName().equals("visitcount"))
				{
					n=Integer.parseInt(c.getValue());
				}
			}
		}
		n++;
		Cookie c=new Cookie("visitcount",""+n);
		response.addCookie(c);
		out.println("Visit count : "+n);
		out.println("<br/> <a href='visitcount'> REFRESH  </a>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
