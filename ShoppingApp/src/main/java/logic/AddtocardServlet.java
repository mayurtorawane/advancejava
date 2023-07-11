package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/addtocard")
public class AddtocardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		int ctid=Integer.parseInt(request.getParameter("category"));
		
		HttpSession session=request.getSession();
		 
		List<Integer> product=(List<Integer>)session.getAttribute("cart");
		
		if(product == null)
		{
			product=new ArrayList<>();
		}
		product.add(ctid);
		session.setAttribute("cart", product);
		
		out.print("</br><p>Selected product  "+ctid+" is Added into the card</P>");
		out.print("</br><p>There are "+ product.size()+" item(s) in the cart</P>");
		
		out.print("</br><a href='viewcart.jsp'>View Cart</a>");
		out.print("</br><a href='home'>Go To Home </a>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
