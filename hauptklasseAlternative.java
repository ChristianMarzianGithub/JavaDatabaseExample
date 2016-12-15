package verwaltung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class hauptKlasse {

	public static void main(String[] args) throws ClassNotFoundException
	  {
	    // load the sqlite-JDBC driver using the current class loader
	    Class.forName("org.sqlite.JDBC");

	    Connection connection = null;
	    try
	    {
	      // create a database connection
	      connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Chris/Desktop/chinook.db");
	      Statement statement = connection.createStatement();
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.

	      ResultSet rs = statement.executeQuery("select * from albums");
	      while(rs.next())
	      {
	        // read the result set
	        System.out.println("name = " + rs.getString("AlbumId"));
	        System.out.println("Title = " + rs.getString("Title"));
	        System.out.println("ArtistID = " + rs.getInt("Artistid"));
	      }
	    }
	    catch(SQLException e)
	    {
	      // if the error message is "out of memory", 
	      // it probably means no database file is found
	      System.err.println(e.getMessage());
	    }
	    finally
	    {
	      try
	      {
	        if(connection != null)
	          connection.close();
	      }
	      catch(SQLException e)
	      {
	        // connection close failed.
	        System.err.println(e);
	      }
	    }
	  }

}
