package app;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class StoredProcessorForEmp {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
        String jdbcurl="jdbc:mysql://localhost:3306/dac";
        Connection con=DriverManager.getConnection(jdbcurl,"root","root");
        System.out.println("connection established");
        
       CallableStatement  cs=con.prepareCall("{call All_Emp()}");
       
       boolean flag=cs.execute();
       ResultSet rs=cs.executeQuery();
       System.out.println(flag);
       
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
