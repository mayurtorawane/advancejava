package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MinMaxSal {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
        String jdbcurl="jdbc:mysql://localhost:3306/dac";
        Connection con=DriverManager.getConnection(jdbcurl,"root","root");
        System.out.println("connection established");
        
        PreparedStatement ps=con.prepareStatement("select * from empdata where sal between ? and ? ");
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the min sal");
        float min=Float.parseFloat(br.readLine());
        System.out.println("Enter the max sal");
        float max=Float.parseFloat(br.readLine());
        
        ps.setFloat(1,min);
        ps.setFloat(2, max);
        
        ResultSet rs=ps.executeQuery();
        
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
