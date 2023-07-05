package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class UpdateEmpdata {

	public static void main(String[] args) throws Exception {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
        String jdbcurl="jdbc:mysql://localhost:3306/dac";
        Connection con=DriverManager.getConnection(jdbcurl,"root","root");
        System.out.println("connection established");
        
        PreparedStatement ps=con.prepareStatement("update empdata set sal=? where empno=?");
        
        ps.setInt(1,6000);
        ps.setInt(2,7788);
        
        int n=ps.executeUpdate();
        
        System.out.println(n+"record updated");
        
        //by using simple statement
        
        Statement st=con.createStatement();
        
        int num=st.executeUpdate("update empdata set sal=6000 where empno=7844");
        
        System.out.println(n+"record updated");
        
        
        
        
        

	}

}
