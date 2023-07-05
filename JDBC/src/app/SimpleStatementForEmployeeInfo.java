package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SimpleStatementForEmployeeInfo {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
        String jdbcurl="jdbc:mysql://localhost:3306/dac";
        Connection con=DriverManager.getConnection(jdbcurl,"root","root");
        System.out.println("connection established");
        
        Statement st=con.createStatement();// created empty container
        
        ResultSet rs=st.executeQuery("select * from empdata");
        
        while(rs.next())
        {
        	System.out.print(rs.getInt(1)+" ");
        	System.out.print(rs.getString(2)+" ");
        	System.out.print(rs.getString(3)+" ");
        	System.out.print(rs.getInt(6)+" ");
        	System.out.print(rs.getInt(8)+" ");
        	System.out.println("");
        }

	}

}
