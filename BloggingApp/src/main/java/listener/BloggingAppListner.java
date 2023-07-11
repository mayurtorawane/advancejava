package listener;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BloggingAppListner implements ServletContextListener {

     Connection con;   
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	 try
         {
        	 con.close();
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
         }
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	
    	String driver=sce.getServletContext().getInitParameter("driverclass");
        String url=sce.getServletContext().getInitParameter("jdbcurl");
        String user=sce.getServletContext().getInitParameter("user");
        String password=sce.getServletContext().getInitParameter("password");
    	try {
    		Class.forName(driver);
    		con=DriverManager.getConnection(url,user,password);
    		sce.getServletContext().setAttribute("jdbccondb",con);
    		System.out.println("connection establish succesfully");
    	}
    	catch (Exception e) {
	    e.printStackTrace();
		}
    }
	
}
