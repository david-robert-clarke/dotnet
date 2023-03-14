import java.sql.*;
import java.io.*;

public class MyConnection 
{
    
  public static void main (String args[])
  {
    // BufferedReader reader = 
    //    new BufferedReader (new InputStreamReader(System.in));
        
    try 
    {
      Class driver = Class.forName("org.postgresql.Driver");
      DriverManager.registerDriver((Driver)driver.newInstance());
	
      // get the values required to connect to the database.
	
      System.out.print("Input the database: ");
      String dbname = "msc67lxb";
      String username = "msc88drc";
      String pw = "charlie";

      // the elements of the database connection url are
      // protocol (jdbc:), subprotocol (postgresql:), 
      // server (//dbhost), and database name (/<dbname>)
	
      String dbUrl = "jdbc:postgresql://dbhost/" + dbname;
      System.out.println("Successfully found database!");
      System.out.println();
	
      Connection c = DriverManager.getConnection(dbUrl, username, pw);
      System.out.println("Successfully connected to database!");

      // Create a result set containing all data from my_table
      Statement stmt = c.createStatement();
      System.out.println("Created Statement");
      ResultSet rs = stmt.executeQuery("SELECT * FROM cd");  

      while (rs.next()) 
          {
              // Get the data from the row using the column index
              /*
              String a = rs.getString(1);
              String b = rs.getString(2);
              String i = rs.getString(3);
              String d = rs.getString(4);
              String e = rs.getString(5);
              String f = rs.getString(6);
              String g = rs.getString(7);
              String h = rs.getString(8);
              System.out.println(a + " " + b + " " + i + " " + d + " " + e
		 + " " + f + " " + g + " " + h);
              */
              String s = rs.getString(1);
              s = rs.getString("artist");
              System.out.println(s);
              
          }

      System.out.println("Successfully executed query!"); 
    }
    catch ( Exception e ) 
    {
      System.out.println( "An exception occurred. " + e);
    }
    /*
    catch (SQLException e)
    {
       System.out.println( "An exception occurred." );
    }
    */
  }
}

