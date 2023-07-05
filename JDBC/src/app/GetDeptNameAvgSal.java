package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetDeptNameAvgSal {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
        String jdbcurl="jdbc:mysql://localhost:3306/dac";
        Connection con=DriverManager.getConnection(jdbcurl,"root","root");
        System.out.println("connection established");
        
        Statement st=con.createStatement();
        
       // ResultSet rs=st.executeQuery("select d.dname,avg(e.sal) as avg_salary from emp e join dept d on e.deptno=d.deptno group by d.dname order by avg_salary desc");
        ResultSet rs=st.executeQuery("select d.dname,avg(e.sal) as avg_salary from dept d,emp e where e.deptno=d.deptno group by d.deptno order by avg_salary desc");
        while(rs.next())
        {
        	System.out.print(rs.getString(1)+" ");
        	System.out.println(rs.getFloat(2)+" ");
        	System.out.println("");
        }
	}

}
