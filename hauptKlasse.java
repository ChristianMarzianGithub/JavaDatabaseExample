package verwaltung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class hauptKlasse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		Connection con;
		Statement stmt;
		try {
			
			
			
			con = DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/classicmodels","root","");
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from customers");
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
				con.close();  
				
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		
		
		
		
	}

}
