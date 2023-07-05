package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;

import intities.Emp;

public class EmpSortingUsingCollection {

	public static void main(String[] args) throws Exception {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
        String jdbcurl="jdbc:mysql://localhost:3306/dac";
        Connection con=DriverManager.getConnection(jdbcurl,"root","root");
        System.out.println("connection established");

        Statement st=con.createStatement();
        
        ResultSet rs=st.executeQuery("select * from empdata");
        
        Set<Emp> emps=new TreeSet<>();
        while(rs.next())
        {
        	Emp e=new Emp(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getDouble(6), rs.getInt(8));
        	emps.add(e);
        }
        
        for(Emp e:emps)
        {
        	System.out.println(e);
        }
	}

}
